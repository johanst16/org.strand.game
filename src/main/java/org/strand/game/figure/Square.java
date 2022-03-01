package org.strand.game.figure;

import org.strand.game.Cell;

public class Square extends AbstractFigure {

    public Square(int height, int width) {
        super(height, width);
    }

    @Override
    public Cell[][] createFigure() {
        content[4][4].setState(true);
        content[4][5].setState(true);
        content[5][4].setState(true);
        content[5][5].setState(true);
        return content;
    }
}