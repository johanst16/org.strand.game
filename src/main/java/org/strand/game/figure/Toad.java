package org.strand.game.figure;

import org.strand.game.Cell;

public class Toad extends AbstractFigure {

    public Toad(int height, int width) {
        super(height, width);
    }

    @Override
    public Cell[][] createFigure() {

        content[4][4].setState(true);
        content[4][5].setState(true);
        content[4][6].setState(true);

        content[5][3].setState(true);
        content[5][4].setState(true);
        content[5][5].setState(true);

        return content;
    }
}