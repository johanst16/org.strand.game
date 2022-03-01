package org.strand.game.fx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import org.strand.game.*;
import org.strand.game.figure.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GuiController implements Initializable, Controller {

    private static final int DISTANCE = 20;
    private static final int SIZE = 10;
    private Playground playground;
    private Group group;
    private GameRules gameRules;

    @FXML
    private AnchorPane rootBox;

    public GuiController() {
    }

    public void start(String load) {

        Playground playground;
        GameRules gameRules;
        Figure figure;
        if(load.equalsIgnoreCase(Main.TEST_FIGURE)) {
            ArrayList<Pair<?, ?>> liveCells = new ArrayList<>();
            liveCells.add(new Pair<>(4, 4));
            liveCells.add(new Pair<>(4, 5));
            liveCells.add(new Pair<>(5, 4));

            figure = new TestFigure(10, 10, liveCells);
        } else if(load.equalsIgnoreCase(Main.BLINKER)) {
            figure = new Blinker(200, 200);
        } else if(load.equalsIgnoreCase(Main.TOAD)) {
            figure = new Toad(200, 200);
        } else if(load.equalsIgnoreCase(Main.OCTAGON2)) {
            figure = new Octagon2(200, 200);
        } else if(load.equalsIgnoreCase(Main.SQUARE)) {
            figure = new Square(200, 200);
        }  else if(load.equalsIgnoreCase(Main.RANDOM)) {
            figure = new Random(200, 200);
        } else {
            figure = new Random(200, 200);
        }

        playground = new Playground(figure);
        gameRules = new GameRules(playground);
        new Play(this, playground, gameRules, 1300).start();
    }

    @Override
    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    @Override
    public void setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new Group();
        rootBox.getChildren().add(group);
    }

    @Override
    public void displayPlayground() {
        Platform.runLater(() -> {
            group.getChildren().clear();

            Cell[][] content = playground.getContent();
            int row = 0;
            for (Cell[] cells : content) {
                int column = 0;
                for (Cell cell : cells) {
                    if(cell.getState()) {
                        Rectangle r = new Rectangle();

                        r.setY(row * DISTANCE);
                        r.setX(column * DISTANCE);
                        r.setWidth(SIZE);
                        r.setHeight(SIZE);
                        r.setFill(Color.RED);
                        group.getChildren().add(r);
                    }
                    column++;
                }
                row++;
            }
            gameRules.applyRules();
            System.out.println("Live cells : " + playground.countLiveCells());
        });
    }

}
