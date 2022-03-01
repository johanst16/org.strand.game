package org.strand.game;

import javafx.util.Pair;
import org.strand.game.figure.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String TEST_FIGURE = "testfigure";
    public static final String BLINKER = "blinker";

    public static final String RANDOM = "random";
    public static final String TOAD = "toad";
    public static final String SQUARE = "square";
    public static final String OCTAGON2 = "octagon2";

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage Main [figure] height width");
            return;
        }

        int height = Integer.parseInt(args[1]);
        int width = Integer.parseInt(args[2]);

        Playground playground;
        GameRules gameRules;
        Figure figure;
        if(args[0].equalsIgnoreCase(TEST_FIGURE)) {
            List<Pair<?, ?>> liveCells = new ArrayList<>();
            liveCells.add(new Pair<>(4, 4));
            liveCells.add(new Pair<>(4, 5));
            liveCells.add(new Pair<>(5, 4));
            figure = new TestFigure(10, 10, liveCells);
        } else if(args[0].equalsIgnoreCase(BLINKER)) {
            figure = new Blinker(height, width);
        } else if(args[0].equalsIgnoreCase(TOAD)) {
            figure = new Toad(height, width);
        } else if(args[0].equalsIgnoreCase(SQUARE)) {
            figure = new Square(height, width);
        } else if(args[0].equalsIgnoreCase(OCTAGON2)) {
            figure = new Octagon2(height, width);
        }  else if(args[0].equalsIgnoreCase(RANDOM)) {
            figure = new Random(height, width);
        } else {
            System.err.println("No such figure...");
            figure = new Random(height, width);
        }

        playground = new Playground(figure);
        gameRules = new GameRules(playground);
        new Play(new SimpleController(), playground, gameRules, 300).start();
    }
}
