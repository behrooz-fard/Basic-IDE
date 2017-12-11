package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.TextArea;

public class Main extends Application {
    public static Parent root;
    public static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        scene = new Scene(root, 2000, 1000);
        primaryStage.setTitle("Basic IDE");
        primaryStage.setScene(scene);
        Node textArea = scene.lookup("#main_text_area");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
