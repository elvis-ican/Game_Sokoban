package com.elvis.game.sokoban.controller;

import com.elvis.game.sokoban.model.Direction;

public interface EventListener {
    void move(Direction direction);

    void restart();

    void startNextLevel();

    void levelCompleted(int level);
}
