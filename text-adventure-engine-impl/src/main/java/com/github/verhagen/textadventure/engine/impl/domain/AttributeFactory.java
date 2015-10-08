package com.github.verhagen.textadventure.engine.impl.domain;

import com.github.verhagen.textadventure.engine.domain.IAttribute;

public class AttributeFactory {

    public IAttribute<String> create(final String name, final String value) {
        return new IAttribute<String>() {
            @Override
            public String getValue() {
                return value;
            }
            
            @Override
            public String getName() {
                return name;
            }
        };
    }

    public IAttribute<Integer> create(final String name, final Integer value) {
        return new IAttribute<Integer>() {
            @Override
            public Integer getValue() {
                return value;
            }
            
            @Override
            public String getName() {
                return name;
            }
        };
    }

    
}
