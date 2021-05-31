package com.elvis.game.sokoban.model;

import java.awt.*;

public class StorageLocation extends GameObject {
    public StorageLocation(int x, int y) {
        super(x, y);
        width = 2;
        height = 2;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int leftTopX = x - width/2;
        int leftTopY = y - height/2;
        graphics.drawOval(leftTopX, leftTopY, width, height);
    }
}
