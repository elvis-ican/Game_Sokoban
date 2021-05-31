package com.elvis.game.sokoban.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path path;

    public LevelLoader(Path levels) {
        path = levels;
    }

    public GameObjects getLevel(int level) {
        int k = Model.BOARD_CELL_SIZE;
        int lev = level > 60 ? level % 60 : level;
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<StorageLocation> storageLocations = new HashSet<>();
        Player player = new Player(0, 0);

        String data = loadFile(lev);
        String s1 = data.split("Size X: ")[1].split("Size Y: ")[0];
        String s2 = data.split("Size X: ")[1].split("Size Y: ")[1].split("End")[0];
        int col = Integer.parseInt(s1);
        int row = Integer.parseInt(s2);
        String s3 = data.split("Length: \\d+")[1];

        int index = 0;
        int y = k / 2;
        for (int i = 0; i < row; i++) {
            int x = k / 2;
            for (int j = 0; j < col; j++) {
                char c = s3.charAt(index);
                if (c == 'X') walls.add(new Wall(x, y));
                if (c == '*') boxes.add(new Box(x, y));
                if (c == '.') storageLocations.add(new StorageLocation(x, y));
                if (c == '@') player = new Player(x, y);
                if (c == '&') {
                    boxes.add(new Box(x, y));
                    storageLocations.add(new StorageLocation(x, y));
                }
                index++;
                x += k;
            }
            y += k;
        }
        return new GameObjects(walls, boxes, storageLocations, player);
    }

    public String loadFile(int level) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream in = getClass().getResourceAsStream(path.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            in.close();
            br.close();
        } catch (IOException e) {}
        String[] levels = sb.toString().split("Maze: ");
        String data = levels[level];
        return data;
    }
}
