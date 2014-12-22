package com.github.verhagen.textadventure.core;

import com.github.verhagen.textadventure.core.impl.domain.AbstractPlayer;

public class AccountPlayer extends AbstractPlayer {
    private final Account account;


    public AccountPlayer(final Account account) {
        this.account = account;
    }


    @Override
    public String getId() {
        return account.getEmail();
    }

    @Override
    public String getName() {
        return account.getName();
    }

}
