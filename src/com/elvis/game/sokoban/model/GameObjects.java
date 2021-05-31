package com.elvis.game.sokoban.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    Set<Wall> walls;
    Set<Box> boxes;
    Set<StorageLocation> storageLocations;
    Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<StorageLocation> storageLocations, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.storageLocations = storageLocations;
        this.player = player;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<StorageLocation> getStorageLocations() {
        return storageLocations;
    }

    public Player getPlayer() {
        return player;
    }

    public Set<GameObject> getAll() {
        Set<GameObject> all = new HashSet<>();
        all.addAll(walls);
        all.addAll(boxes);
        all.addAll(storageLocations);
        all.add(player);
        return all;
    }

}
