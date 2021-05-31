package com.elvis.game.sokoban.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.MAGENTA);
        int leftTopX = getX() - getWidth()/2;
        int leftTopY = getY() - getHeight()/2;
        graphics.drawOval(leftTopX, leftTopY, 14, 14);
        graphics.fillOval(leftTopX, leftTopY, 14, 14);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
