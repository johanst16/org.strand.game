package org.strand.game;

import org.strand.game.figure.Figure;

public class Playground {

    private final Cell[][] content;
    private final int playgroundWidth;
    private final int playgroundHeight;

    public Playground(Figure figure) {
        this.playgroundHeight = figure.getHeight();
        this.playgroundWidth = figure.getWidth();
        content = figure.createFigure();
    }

    public Cell[][] getContent() {
        return content;
    }

    public int getPlaygroundWidth() {
        return playgroundWidth;
    }

    public int getPlaygroundHeight() {
        return playgroundHeight;
    }

    public int countLiveCells() {
        int liveCells = 0;
        for (Cell[] cells : content) {
            for (Cell cell : cells) {
                if (cell.getState()) {
                    liveCells++;
                }
            }
        }
        return liveCells;
    }
}
