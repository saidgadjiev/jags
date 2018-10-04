package ru.saidgadjiev.calculator.lexer;

/**
 * Created by said on 29.09.2018.
 */
public class Token {

    private final TokenType tokenType;

    private final String value;

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getValue() {
        return value;
    }

    public enum TokenType {

        NUMBER,

        PLUS,

        MINUS,

        TIMES,

        BRACKET,

        EXPONENTIATION,

        DIV,

        EOF

    }
}
