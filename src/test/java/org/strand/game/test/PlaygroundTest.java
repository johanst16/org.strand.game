package org.strand.game.test;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.strand.game.Playground;
import org.strand.game.figure.TestFigure;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundTest {

    @Test
    public void playgroundTest() {

        List<Pair<?, ?>> liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(1, 4));
        liveCells.add(new Pair<>(2, 4));
        liveCells.add(new Pair<>(3, 4));
        Playground playground = new Playground(new TestFigure(7, 8, liveCells));

        Assert.assertEquals(3, playground.countLiveCells());
        Assert.assertEquals(8, playground.getPlaygroundWidth());
        Assert.assertEquals(7, playground.getPlaygroundHeight());
    }
}
