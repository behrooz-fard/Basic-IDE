package sample;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.CodeArea;
import pythonParser.Python3Lexer;

import java.util.ArrayList;
import java.util.List;

public class Highlighter {
    static String t;
    static CodeArea codeArea = new CodeArea();

    public static void setString(String t) {
        Highlighter.t = t;
    }


    public static void Highlight() {
        CharStream stream = new ANTLRInputStream(t);
        Python3Lexer lexer = new Python3Lexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            System.out.println(token);
            // Exit in EOF
            if (token.getType() == -1)
                break;
            if (token.getType() == 4) {
                List<String> styles= new ArrayList<>();
                codeArea.replaceText(0, token.getText().length(), token.getText());
                for (int i = 0; i < token.getText().length(); i++)
                    styles.add("-fx-background-color: brown;");
                System.out.println("SIZE: " + styles.size());
                codeArea.setStyle(token.getStartIndex(), token.getStopIndex()+1,
                        styles);
            }
        }
    }
}