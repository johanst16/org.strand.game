package org.strand.game.figure;

import javafx.util.Pair;
import org.strand.game.Cell;

import java.util.List;

public class TestFigure extends AbstractFigure {

    private final List<Pair<?, ?>> liveCells;

    public TestFigure(int height, int width, List<Pair<?, ?>> liveCells) {
        super(height, width);
        this.liveCells = liveCells;
    }

    @Override
    public Cell[][] createFigure() {

        for(Pair<?,?> pair: liveCells) {
            content[(int) pair.getKey()][(int) pair.getValue()].setState(true);
        }
        return content;
    }
}
