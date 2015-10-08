package com.github.verhagen.textadventure.engine;

import com.github.verhagen.textadventure.engine.domain.IPlayer;

public class PlayerFactory {

    public IPlayer create(Account account) {
        return new AccountPlayer(account);
    }

}
