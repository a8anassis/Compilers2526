package gr.aueb.compilers.lexer;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File inputFile = new File("C:\\tmp\\lexer.txt");

        try {
            ILexer lexer = new LexerImpl(inputFile);

            while (true) {
                TokenClass tokenClass = lexer.getNextToken();
                System.out.println(tokenClass);

                if (tokenClass == TokenClass.EOF) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
