package com.elvis.game.sokoban.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0x994C00));
        int leftTopX = x - width/2;
        int leftTopY = y - height/2;
        graphics.drawRect(leftTopX, leftTopY, 19, 19);
        graphics.fillRect(leftTopX, leftTopY, 19, 19);
    }
}
