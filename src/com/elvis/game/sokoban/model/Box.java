package com.elvis.game.sokoban.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int leftTopX = x - width/2;
        int leftTopY = y - height/2;
        graphics.drawRoundRect(leftTopX, leftTopY, 15, 15, 2, 2);
        graphics.fillRoundRect(leftTopX, leftTopY, 15, 15, 2, 2);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
