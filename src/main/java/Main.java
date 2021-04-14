
/*
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

 */
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller;

import java.io.IOException;


public class Main extends Application {

    private static final double W = 600, H = 400;

    String fxml ="fxml/sample.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
        Parent root = null;   try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene sc = new Scene(root);
        Controller c =loader.getController();
        c.setScene(sc);
        stage.setScene(sc);
        stage.setTitle("Narutin");
        stage.show();

    }


    public static void main(String[] args) { launch(args); }
}
