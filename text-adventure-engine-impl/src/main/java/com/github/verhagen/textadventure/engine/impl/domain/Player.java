package com.github.verhagen.textadventure.engine.impl.domain;


public class Player extends AbstractPlayer {
    private final String id;
    private final String name;

    
    public Player(final String id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
