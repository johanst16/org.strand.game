package org.strand.game.test;

import javafx.util.Pair;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strand.game.*;
import org.strand.game.figure.TestFigure;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameRulesTest {

    private static Controller controller;
    private static List<Pair<?, ?>> liveCells;

    @BeforeClass
    public static void beforeClass() {
        controller = new SimpleController();
    }

    @Test
    public void testCellWithFewerThanTwoLiveNeighboursDies() {
        /*
                1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
         */
        liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(4, 4));
        Playground playground = new Playground(new TestFigure(8, 8, liveCells));
        GameRules gameRules = new GameRules(playground);
        Play play = new Play(controller, playground, gameRules,300);

        assertEquals(1, playground.countLiveCells());
        play.applyRules();
        assertEquals(0, playground.countLiveCells());
    }

    @Test
    public void testAnyLiveCellWithTwoOrThreeLiveNeighboursLivesToNextGeneration() {
        /*
                2. Any live cell with two or three live neighbours lives on to the next generation.
         */
        liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(4, 4));
        liveCells.add(new Pair<>(4, 5));
        liveCells.add(new Pair<>(5, 4));
        liveCells.add(new Pair<>(5, 5));
        Playground playground = new Playground(new TestFigure(10, 10, liveCells));
        GameRules gameRules = new GameRules(playground);
        Play play = new Play(controller, playground, gameRules,300);

        assertEquals(4, playground.countLiveCells());
        play.applyRules();
        assertEquals(4, playground.countLiveCells());
    }

    @Test
    public void testAnyLiveCellWithMoreThanThreeLiveNeighboursDies() {
        /*
            3. Any live cell with more than three live neighbours dies, as if by overpopulation.
         */
        liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(1, 4));
        liveCells.add(new Pair<>(2, 3)); // dies
        liveCells.add(new Pair<>(2, 4)); // dies
        liveCells.add(new Pair<>(3, 3));
        liveCells.add(new Pair<>(3, 4));
        Playground playground = new Playground(new TestFigure(8, 8, liveCells));
        GameRules gameRules = new GameRules(playground);
        Play play = new Play(controller, playground, gameRules,300);

        assertEquals(5, playground.countLiveCells());
        play.applyRules();
        assertEquals(5, playground.countLiveCells());
        Cell[][] content = playground.getContent();
        assertFalse(content[2][3].getState());
        assertFalse(content[2][4].getState());

    }

    @Test
    public void testAnyDeadCellWithExactlyThreeLiveNeighboursBecomesAlive() {
        /*
            4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
         */
        liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(4, 4));
        liveCells.add(new Pair<>(4, 5));
        liveCells.add(new Pair<>(5, 4));
        Playground playground = new Playground(new TestFigure(10, 10, liveCells));
        GameRules gameRules = new GameRules(playground);
        Play play = new Play(controller, playground, gameRules,300);

        assertEquals(3, playground.countLiveCells());
        play.applyRules();
        assertEquals(4, playground.countLiveCells());
    }

    @Test
    public void testFiveLiveCellsToFiveCellsToThreeToTwoToZero() {

        liveCells = new ArrayList<>();
        liveCells.add(new Pair<>(1, 4));
        liveCells.add(new Pair<>(2, 3));
        liveCells.add(new Pair<>(2, 4));
        liveCells.add(new Pair<>(3, 3));
        liveCells.add(new Pair<>(3, 4));
        Playground playground = new Playground(new TestFigure(8, 8, liveCells));
        GameRules gameRules = new GameRules(playground);
        Play play = new Play(controller, playground, gameRules,300);

        assertEquals(5, playground.countLiveCells());
        play.applyRules();

        assertEquals(5, playground.countLiveCells());
        play.applyRules();

        assertEquals(3, playground.countLiveCells());
        play.applyRules();

        assertEquals(2, playground.countLiveCells());
        play.applyRules();

        assertEquals(0, playground.countLiveCells());
        play.applyRules();
    }
}
