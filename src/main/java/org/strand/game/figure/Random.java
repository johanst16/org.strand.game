package org.strand.game.figure;

import org.strand.game.Cell;

public class Random extends AbstractFigure {

    public Random(int height, int width) {
        super(height, width);
    }

    @Override
    public Cell[][] createFigure() {

        int numberOfActiveCell = 0;
        for (Cell[] cells : content) {
            for (Cell cell : cells) {
                if (Math.random() < 0.2) {
                    cell.setState(true);
                    numberOfActiveCell++;
                }
            }
        }

        System.out.println("number of Active cells from start : " + numberOfActiveCell);
        return content;
    }
}
