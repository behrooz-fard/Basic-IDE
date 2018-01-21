package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private MenuBar menuBar;
    private File chosenFile;
    private CodeArea mainCodeArea;


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

        //open file in code area
        Controller.openFileInTextEditor(chosenFile);


        CodeArea codeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");

    }

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        menuBar.setFocusTraversable(true);
//        WebView webView = (WebView) Main.scene.lookup("webView");

    }

    @FXML
    public void saveFile() {

        try {

            mainCodeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");
            // create a buffered writer to write to a file
            BufferedWriter out = new BufferedWriter(new FileWriter(chosenFile.getPath()));
            out.write(mainCodeArea.getText()); // write the contents of the TextArea to the file
            out.close(); // close the file stream

        } catch (Exception ex) {

            // ...write to the debug console
            System.out.println(ex.getMessage());
        }
    }

    public void saveFileAs() {

        FileChooser fileChooser = new FileChooser();
        File dest = fileChooser.showSaveDialog(new Stage());
        if (dest != null) {
            try {

                mainCodeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");
                // create a buffered writer to write to a file
                BufferedWriter out = new BufferedWriter(new FileWriter(dest.getPath()));
                out.write(mainCodeArea.getText()); // write the contents of the TextArea to the file
                out.close(); // close the file stream
            } catch (IOException ex) {

                // ...write to the debug console
                System.out.println(ex.getMessage());
            }
        }
    }

    public void cut() {

        mainCodeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");
        mainCodeArea.cut();
    }

    public void copy() {

        mainCodeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");
        mainCodeArea.copy();
    }

    public void paste() {

        mainCodeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");
        mainCodeArea.paste();
    }
    public void compile(){
        System.out.println("COMPILE");
//        if (chosenFile == null){
//
//        }
        System.out.println("FILE: " + chosenFile.getAbsolutePath());
        String lang = Controller.detectLang(chosenFile);

        switch (lang) {
            case "Python":
                System.out.println("IS PYTHON");
                System.out.println(chosenFile.getAbsolutePath());

                try {
                    String[] command = {"gnome-terminal", "-x", "python3", chosenFile.getAbsolutePath()};
                    Process proc = new ProcessBuilder(command).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "C++":
            case "C":
                System.out.println("IS CPP");
                System.out.println(chosenFile.getAbsolutePath());

                try {
                    String[] command = {"gnome-terminal", "-x", "gcc", "-o", chosenFile.getName().substring(0, chosenFile.getName().indexOf(".")), chosenFile.getAbsolutePath()};
                    Process proc = new ProcessBuilder(command).start();
                    proc = new ProcessBuilder("./" + chosenFile.getName().substring(0, chosenFile.getName().indexOf("."))).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "java":
                System.out.println("IS java");
                System.out.println(chosenFile.getAbsolutePath());

                try {
                    String[] command = {"gnome-terminal", "-x", "java", "-c", chosenFile.getName().substring(0, chosenFile.getName().indexOf(".")), chosenFile.getAbsolutePath()};
                    Process proc = new ProcessBuilder(command).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    @FXML
    void exit(){
        System.exit(1);
    }
}
