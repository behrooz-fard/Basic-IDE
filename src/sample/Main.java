package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static Parent root;
    public static Scene scene;
    public static String[] margs;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        scene = new Scene(root, 2000, 1000);
        primaryStage.setTitle("Basic IDE");
        primaryStage.setScene(scene);
        Node codeArea = scene.lookup("#mainCodeArea");
        primaryStage.show();


    }


    public static void main(String[] args) throws IOException, InterruptedException {

        launch(args);

    }
}