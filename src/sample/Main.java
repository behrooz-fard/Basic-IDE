package sample;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
public class Main extends Application {
    private static Parent root;
    public static Scene scene;
    public static String[] margs;

    @FXML
    private File openFile() {
        //as log
        System.out.println("OPEN FILE");

        //create file chooser
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        //legal file types
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "*.c", "*.cpp", "*.java", "*.py"
        ));

        File chosenFile = chooser.showOpenDialog(new Stage());
        System.out.println(chosenFile.getAbsolutePath() + " SELECTED");
        return chosenFile;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        scene = new Scene(root, 2000, 1000);
        primaryStage.setTitle("Basic IDE");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        Node codeArea = scene.lookup("#mainCodeArea");
        codeArea.autosize();
        codeArea.setStyle("-fx-font-size: 25pt;");

        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}