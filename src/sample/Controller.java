package sample;

import javafx.scene.control.TextArea;
import sample.Main;

import java.io.*;

public class Controller {

    static void openFileInTextEditor(File file){
        //get text area
        TextArea textArea = (TextArea) Main.scene.lookup("#main_text_area");

        try {
            //reading file
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String str = new String(data, "UTF-8");

            //put text in text area
            textArea.setText(str);

        } catch (FileNotFoundException e) {
           System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
