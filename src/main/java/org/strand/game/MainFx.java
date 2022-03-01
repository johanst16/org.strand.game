package org.strand.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.strand.game.fx.GuiController;

import java.util.List;

public class MainFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parameters params = getParameters();
        List<String> list = params.getRaw();
        FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/guiController.fxml"));

        Parent root;
        root = loader.load();

        GuiController guiController = loader.getController();
        if(list.size() > 0 && list.get(0) != null) {
            guiController.start(list.get(0));
        } else {
            guiController.start(Main.RANDOM);
        }

        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

}