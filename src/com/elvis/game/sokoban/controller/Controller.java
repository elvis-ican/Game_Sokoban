package com.elvis.game.sokoban.controller;

import com.elvis.game.sokoban.model.Direction;
import com.elvis.game.sokoban.model.GameObjects;
import com.elvis.game.sokoban.model.Model;
import com.elvis.game.sokoban.view.View;

public class Controller implements EventListener {
    private View view;
    private Model model;

    public Controller() {
        model = new Model();
        model.restart();
        model.setEventListener(this);
        view = new View(this);
        view.init();
        view.setEventListener(this);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.setTitle("Sokoban - Level " + getCurrentLevel());
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }

    public int getCurrentLevel() {
        return model.getCurrentLevel();
    }

}
