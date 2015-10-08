package com.github.verhagen.textadventure.engine;

import com.github.verhagen.textadventure.engine.command.ICommandRegistery;
import com.github.verhagen.textadventure.engine.impl.command.CommandGet;
import com.github.verhagen.textadventure.engine.impl.command.CommandInventory;
import com.github.verhagen.textadventure.engine.impl.command.CommandLook;
import com.github.verhagen.textadventure.engine.impl.command.CommandRegistery;

public class GameBeans {
    private static PlayerFactory playerFactory;


    public static PlayerFactory getPlayerFactory() {
        if (playerFactory == null) {
            playerFactory = new PlayerFactory();
        }
        return playerFactory;
    }

    public static ICommandRegistery getCommandRegistery() {
        CommandRegistery commandRegistery = new CommandRegistery();
        commandRegistery.register(new CommandGet());
        commandRegistery.register(new CommandInventory());
        commandRegistery.register(new CommandLook());
//        commandRegistery.register(new Command);
        return commandRegistery;
    }
}
