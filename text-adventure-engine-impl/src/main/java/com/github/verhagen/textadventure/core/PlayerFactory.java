package com.github.verhagen.textadventure.core;

import com.github.verhagen.textadventure.core.domain.IPlayer;

public class PlayerFactory {

    public IPlayer create(Account account) {
        return new AccountPlayer(account);
    }

}
