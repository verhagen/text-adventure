package com.github.verhagen.textadventure.story;

import static java.util.regex.Pattern.compile;

import java.util.Locale;
import java.util.regex.Matcher;

import org.jbehave.core.Embeddable;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;

/**
 * Implements {@link StoryPathResolver} which can read dash separated story names. 
 * Similar as the {@link UnderscoredCamelCaseResolver} which is not really configurable, 
 * for different separator characters.
 * It also is not final, but the fields {@code resolutionPattern, locale, wordToRemove},
 * can not be used from an extended class.
 * No idea why there is a wordToRemote at all. And when it would be necessary, it would be
 * nicer to have it as a filter. And create a proxy chain, in case the filter is needed.
 */
public class DashCamelCaseResolver extends UnderscoredCamelCaseResolver {
	private static final String SEPARATOR = "-";
	private final String resolutionPattern = NUMBERS_AS_UPPER_CASE_LETTERS_PATTERN;
    private final Locale locale = Locale.getDefault();
    private String wordToRemove = "";

	@Override
	protected String resolveName(
			Class<? extends Embeddable> embeddableClass) {
        String simpleName = embeddableClass.getSimpleName();
        simpleName = simpleName.replace(wordToRemove, "");
        Matcher matcher = compile(resolutionPattern).matcher(
                simpleName);
		int startAt = 0;
		StringBuilder builder = new StringBuilder();
		while (matcher.find(startAt)) {
			builder.append(matcher.group(1).toLowerCase(locale));
			builder.append(SEPARATOR);
			startAt = matcher.start(2);
		}
		return builder.substring(0, builder.length() - 1);
	}

}
