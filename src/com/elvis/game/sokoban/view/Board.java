package com.elvis.game.sokoban.view;

import com.elvis.game.sokoban.controller.EventListener;
import com.elvis.game.sokoban.model.Direction;
import com.elvis.game.sokoban.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

import static java.awt.event.KeyEvent.*;

public class Board extends JPanel {
    private View view;
    private EventListener eventListener;

    public Board(View view) {
        this.view = view;
        KeyHandler handler = new KeyHandler();
        addKeyListener(handler);
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        Set<GameObject> all = view.getGameObjects().getAll();
        for (GameObject object : all) {
            object.draw(g);
        }
    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case VK_LEFT:
                        eventListener.move(Direction.LEFT);
                        break;
                    case VK_RIGHT:
                        eventListener.move(Direction.RIGHT);
                        break;
                    case VK_UP:
                        eventListener.move(Direction.UP);
                        break;
                    case VK_DOWN:
                        eventListener.move(Direction.DOWN);
                        break;
                    case VK_SPACE:
                        eventListener.restart();
                }
        }
    }
}
