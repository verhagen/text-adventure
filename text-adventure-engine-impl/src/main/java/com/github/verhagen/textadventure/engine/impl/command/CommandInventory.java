package com.github.verhagen.textadventure.engine.impl.command;

import java.util.Set;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;
import com.github.verhagen.textadventure.engine.domain.IPlayer;

public class CommandInventory extends AbstractCommand {

    public CommandInventory() {
        super("inventory", "i");
    }

    @Override
    public void execute(IPlayer player, IObjectVisitor visitor, String argument) {
        Set<IItem> items = player.getItems();
        if (items.size() == 0) {
            visitor.append("You are not carrying anything.");
        }
        else {
            visitor.append("Inventory");
            visitor.accept(player);
        }
    }

}
