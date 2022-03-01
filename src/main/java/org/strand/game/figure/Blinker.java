package org.strand.game.figure;

import org.strand.game.Cell;

public class Blinker extends AbstractFigure {

    public Blinker(int height, int width) {
        super(height, width);
    }

    @Override
    public Cell[][] createFigure() {
        content[4][4].setState(true);
        content[4][5].setState(true);
        content[4][6].setState(true);
        return content;
    }
}