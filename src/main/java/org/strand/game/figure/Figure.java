package org.strand.game.figure;

import org.strand.game.Cell;

public interface Figure {
    Cell[][] createFigure();
    int getHeight();
    int getWidth();
}
