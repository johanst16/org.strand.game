package org.strand.game.figure;

import org.strand.game.Cell;

public abstract class AbstractFigure implements Figure {

    protected Cell[][] content;
    private final int height;
    public final int width;

    protected AbstractFigure(int height, int width) {
        this.height = height;
        this.width = width;
        content = new Cell[height][width];
        for (int h = 0; h < content.length; h++){
            for (int w = 0; w < content[h].length; w++) {
                content[h][w] = new Cell();
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}