package org.strand.game.figure;

import org.strand.game.Cell;

public class Octagon2 extends AbstractFigure {

    public Octagon2(int height, int width) {
        super(height, width);
    }

    @Override
    public Cell[][] createFigure() {
        content[2][5].setState(true);
        content[2][6].setState(true);

        content[3][4].setState(true);
        content[3][7].setState(true);

        content[4][3].setState(true);
        content[4][8].setState(true);

        content[5][2].setState(true);
        content[5][9].setState(true);

        content[6][2].setState(true);
        content[6][9].setState(true);

        content[7][3].setState(true);
        content[7][8].setState(true);

        content[8][4].setState(true);
        content[8][7].setState(true);

        content[9][5].setState(true);
        content[9][6].setState(true);

        return content;
    }
}
