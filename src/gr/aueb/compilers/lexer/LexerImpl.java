package gr.aueb.compilers.lexer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LexerImpl implements ILexer {

    private final static Map<String, TokenClass> lexemes = new HashMap<String, TokenClass>();

    static {
        for (TokenClass token : TokenClass.values()) {
            if (token != null) {
                lexemes.put(token.getLexeme(), token);
            }
        }
    }

    private final Scanner in;
    private String lexeme;

    // Groups: 1 = whitespace, 2 = identifier/keyword, 3 = number. Longer operators come before shorter ones.
    private final Pattern pattern = Pattern.compile("(\\s+)|([a-zA-Z][a-zA-Z0-9_]*)|(\\d+)|" +
            "--|\\+\\+|>=|<=|==|!=|.");

    @Override
    public TokenClass getNextToken() throws IOException {
        lexeme = "";

        while (in.findWithinHorizon(pattern, 0) != null) {
            lexeme = in.match().group(0);

            if (in.match().group(1) != null) {
                continue;
            } else if (in.match().group(2) != null) {
                TokenClass keyword = lexemes.get(lexeme);
                return keyword == null ? TokenClass.ID : keyword;
            } else if (in.match().group(3) != null) {
                return TokenClass.NUM;
            }

            TokenClass token = lexemes.get(lexeme);
            return  token == null ? TokenClass.ERROR : token;
        }
        return TokenClass.EOF;
    }

    public LexerImpl(File inputString) throws IOException {
        in = new Scanner(inputString);
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
