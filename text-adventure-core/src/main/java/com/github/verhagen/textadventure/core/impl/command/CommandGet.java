package com.github.verhagen.textadventure.core.impl.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;

public class CommandGet extends AbstractCommand {
    private final Logger logger = LoggerFactory.getLogger(CommandGet.class); 

    public CommandGet() {
        super("get", "take");
    }

    @Override
    public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
        if (args == null || args.length == 0 || "".equals(args[0].trim())) {
            visitor.append("Wat should be taken?");
            return;
        }

        String itemId = "map";
        logger.info("Trying to '" + getName() + "' '" + itemId + "'");
        if (player.getLocation().contains(itemId)) {
            IItem item = player.getLocation().remove(itemId);
            player.add(item);
            visitor.append("You took the " + args[0]);
        }
        else {
            visitor.append("Nothing here that looks like a " + args[0]);
        }
    }

}
