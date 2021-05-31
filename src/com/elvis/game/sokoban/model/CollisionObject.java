package com.elvis.game.sokoban.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        if (direction == Direction.LEFT && (getX() - Model.BOARD_CELL_SIZE == gameObject.getX()) &&
                getY() == gameObject.getY())
            return true;
        if (direction == Direction.RIGHT && (getX() + Model.BOARD_CELL_SIZE == gameObject.getX()) &&
                getY() == gameObject.getY())
            return true;
        if (direction == Direction.UP && (getY() - Model.BOARD_CELL_SIZE == gameObject.getY()) &&
                getX() == gameObject.getX())
            return true;
        if (direction == Direction.DOWN && (getY() + Model.BOARD_CELL_SIZE == gameObject.getY()) &&
                getX() == gameObject.getX())
            return true;
        return false;
    }
}
