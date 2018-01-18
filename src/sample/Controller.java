package sample;

import org.fxmisc.richtext.CodeArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

    static void openFileInTextEditor(File file) {
        //get code area
        CodeArea codeArea = (CodeArea) Main.scene.lookup("#mainCodeArea");

        try {
            //reading file
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String str = new String(data, "UTF-8");


            //put text in code area
            codeArea.replaceText(str);

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
