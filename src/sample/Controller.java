package sample;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

    static void openFileInTextEditor(File file) {
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
//    static void textEditorChiz(){
//        ANTLRParser parser = new ANTLRParser(new TokenStream());
//    }
}
