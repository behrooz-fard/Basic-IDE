package sample;

import cParser.CLexer;
import cppParser.CPP14Lexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.CodeArea;
import pythonParser.Python3Lexer;
import javaParser.JavaLexer;
public class Highlighter {
    static String t;
    static CodeArea codeArea = new CodeArea();

    public static void setString(String t) {
        Highlighter.t = t;
    }


    public static void PythonHighlight() {
        CharStream stream = new ANTLRInputStream(t);
        Python3Lexer lexer = new Python3Lexer(stream);
        Token token;
        while (true) {
            token = lexer.nextToken();
            System.out.println(token);
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
            System.out.println(token);
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
            System.out.println(token);
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
            System.out.println(token);
            // Exit in EOF
            if (token.getType() == -1)
                break;
        }
    }
}