package com.github.verhagen.textadventure.engine.impl.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;
import com.github.verhagen.textadventure.engine.domain.IPlayer;

public class CommandGet extends AbstractCommand {
    private final Logger logger = LoggerFactory.getLogger(CommandGet.class); 

    public CommandGet() {
        super("get", "take");
    }

    @Override
    public void execute(IPlayer player, IObjectVisitor visitor, String argument) {
        if (argument == null || argument.trim().length() == 0) {
            visitor.append("What should be taken?");
            return;
        }
        
        String itemName = argument.trim();
        logger.info("Trying to '" + getName() + "' '" + itemName + "'");
        if (player.getLocation().contains(itemName)) {
            IItem item = player.getLocation().remove(itemName);
            player.add(item);
            visitor.append("You took the " + itemName);
        }
        else {
            visitor.append("Nothing here that looks like a " + itemName);
        }
    }

}
