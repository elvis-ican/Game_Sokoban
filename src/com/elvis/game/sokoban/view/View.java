package com.elvis.game.sokoban.view;

import com.elvis.game.sokoban.controller.Controller;
import com.elvis.game.sokoban.controller.EventListener;
import com.elvis.game.sokoban.model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Board board;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        board = new Board(this);
        add(board);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Sokoban - Level " + controller.getCurrentLevel());
        setVisible(true);
    }

    public void setEventListener(EventListener eventListener) {
        board.setEventListener(eventListener);
    }

    public void update() {
        board.repaint();
    }

    public GameObjects getGameObjects() {
        return controller.getGameObjects();
    }

    public void completed(int level) {
        update();
        JOptionPane.showMessageDialog(board,"You completed Level " + level + "!\nStart next level.");
        controller.startNextLevel();
    }
}