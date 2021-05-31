package com.elvis.game.sokoban.model;

import com.elvis.game.sokoban.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static int BOARD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("../res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction))
            return;
        if (checkBoxCollisionAndMoveIfAvaliable(direction))
            return;
        else switch (direction) {
            case LEFT: player.move(-BOARD_CELL_SIZE, 0); break;
            case RIGHT: player.move(BOARD_CELL_SIZE, 0); break;
            case UP: player.move(0, -BOARD_CELL_SIZE); break;
            case DOWN: player.move(0, BOARD_CELL_SIZE);
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls())
            if (gameObject.isCollision(wall, direction))
                return true;
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                if (checkWallCollision(box, direction))
                    return true;
                for (Box otherBox : gameObjects.getBoxes()) {
                    if (box.isCollision(otherBox, direction))
                        return true;
                }
                switch (direction) {
                    case LEFT: box.move(-BOARD_CELL_SIZE, 0); break;
                    case RIGHT: box.move(BOARD_CELL_SIZE, 0); break;
                    case UP: box.move(0, -BOARD_CELL_SIZE); break;
                    case DOWN: box.move(0, BOARD_CELL_SIZE);
                }
            }
        }
        return false;
    }

    public void checkCompletion() {
        int countMatch = 0;
        for (StorageLocation storageLocation : gameObjects.storageLocations) {
            for (Box box : gameObjects.boxes) {
                if (storageLocation.x == box.x && storageLocation.y == box.y)
                    countMatch++;
            }
        }
        if (countMatch == gameObjects.storageLocations.size())
            eventListener.levelCompleted(currentLevel);
    }

}
