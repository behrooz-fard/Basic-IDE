package sample;

import org.fxmisc.richtext.CodeArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Controller {

    static String detectLang(File file){
        String lang;
        if (file.getAbsolutePath().endsWith(".py"))
            lang = "Python";
        else if (file.getAbsolutePath().endsWith(".java"))
            lang = "java";
        else if (file.getAbsolutePath().endsWith(".c"))
            lang = "C";
        else if (file.getAbsolutePath().endsWith(".cpp"))
            lang = "C++";
        else
            lang = "!";
        return lang;
    }
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
            Highlighter.setString(str);
            String lang = detectLang(file);

            switch (lang){
                case "C":
                    Highlighter.CHighlight();
                    break;
                case "C++":
                    Highlighter.CPPHighlight();
                    break;
                case "Python":
                    Highlighter.PythonHighlight();
                    break;
                default:
                    Highlighter.JavaHighlight();
                    break;
            }


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
