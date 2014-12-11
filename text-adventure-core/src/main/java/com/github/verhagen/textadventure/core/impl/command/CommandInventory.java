package com.github.verhagen.textadventure.core.impl.command;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;

public class CommandInventory extends AbstractCommand {

    public CommandInventory() {
        super("inventory", "i");
    }

    @Override
    public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
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
