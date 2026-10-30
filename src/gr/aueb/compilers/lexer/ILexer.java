package gr.aueb.compilers.lexer;

import java.io.IOException;

public interface ILexer {
    TokenClass getNextToken() throws IOException;
    String getLexeme();
}
