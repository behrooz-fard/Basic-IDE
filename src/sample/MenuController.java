package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private MenuBar menuBar;
    private File chosenFile;


    @FXML
    private void handleInput(final InputEvent event) {
        System.out.println("CALLED: " + event);
    }

    @FXML
    private void openFile() {
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

        chosenFile = chooser.showOpenDialog(new Stage());
        System.out.println(chosenFile.getAbsolutePath() + " SELECTED");

        //open file in text area
        Controller.openFileInTextEditor(chosenFile);

    }

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        menuBar.setFocusTraversable(true);

    }

    @FXML
    public void saveFile() {

        try {

            //get text area
            TextArea textArea = (TextArea) Main.scene.lookup("#main_text_area");

            // create a buffered writer to write to a file
            BufferedWriter out = new BufferedWriter(new FileWriter(chosenFile.getPath()));
            out.write(textArea.getText()); // write the contents of the TextArea to the file
            out.close(); // close the file stream

        } catch (Exception ex) {

            // ...write to the debug console
            System.out.println(ex.getMessage());
        }
    }
}
