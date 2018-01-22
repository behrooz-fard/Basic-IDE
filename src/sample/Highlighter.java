package sample;

import cParser.CLexer;
import cppParser.CPP14Lexer;
import javaParser.JavaLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.CodeArea;
import pythonParser.Python3Lexer;

class Highlighter {
    private static String t;
    //    static CodeArea codeArea = new CodeArea();
    private static final CodeArea highlighterCodeArea = (CodeArea) Main.scene.lookup("#highlighterCodeArea");

    public static void setString(String t) {
        Highlighter.t = t;
        highlighterCodeArea.clear();
    }


    public static void PythonHighlight() {
        CharStream stream = new ANTLRInputStream(t);
        Python3Lexer lexer = new Python3Lexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            highlighterCodeArea.appendText(
                    "\ntext: " + token.getText() +
                            "\t\ttype: " + token.getType() +
                            "\t\tline: " + token.getLine() + "\n");
            // Exit in EOF
            if (token.getType() == -1)
                break;
        }
    }

    public static void JavaHighlight() {
        CharStream stream = new ANTLRInputStream(t);
        JavaLexer lexer = new JavaLexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            highlighterCodeArea.appendText(
                    "\ntext: " + token.getText() +
                            "\t\ttype: " + token.getType() +
                            "\t\tline: " + token.getLine() + "\n");
            // Exit in EOF
            if (token.getType() == -1)
                break;
        }
    }

    public static void CHighlight() {
        CharStream stream = new ANTLRInputStream(t);
        CLexer lexer = new CLexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            highlighterCodeArea.appendText(
                    "\ntext: " + token.getText() +
                            "\t\ttype: " + token.getType() +
                            "\t\tline: " + token.getLine() + "\n");
            // Exit in EOF
            if (token.getType() == -1)
                break;
        }
    }

    public static void CPPHighlight() {
        CharStream stream = new ANTLRInputStream(t);
        CPP14Lexer lexer = new CPP14Lexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            highlighterCodeArea.appendText(
                    "\ntext: " + token.getText() +
                            "\t\ttype: " + token.getType() +
                            "\t\tline: " + token.getLine() + "\n");
            // Exit in EOF
            if (token.getType() == -1)
                break;
        }
    }
}