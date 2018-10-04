package ru.saidgadjiev.calculator.lexer;

/**
 * Created by said on 29.09.2018.
 */
public class CalculatorLexer {

    private final char EOF = (char) -1;

    private final String input;

    private char ch;

    private int p = 0;

    public CalculatorLexer(String input) {
        this.input = input;

        ch = input.charAt(p);
    }

    public Token nextToken() {
        while (ch != EOF) {
            switch (ch) {
                case ' ':
                case '\t':
                case '\n':
                    ws();
                    break;
                case '-':
                    consume();

                    return new Token(Token.TokenType.MINUS, "-");
                case '+':
                    consume();

                    return new Token(Token.TokenType.PLUS, "+");
                case '*':
                    consume();

                    return new Token(Token.TokenType.TIMES, "*");
                case '/':
                    consume();

                    return new Token(Token.TokenType.DIV, "/");
                case '(':
                    consume();

                    return new Token(Token.TokenType.BRACKET, "(");
                case ')':
                    consume();

                    return new Token(Token.TokenType.BRACKET, ")");
                case '^':
                    consume();

                    return new Token(Token.TokenType.EXPONENTIATION, "^");
                default:
                    if (isNumber()) {
                        return number();
                    }

                    throw new IllegalArgumentException("Expected number but found: " + ch);
            }
        }

        return new Token(Token.TokenType.EOF, "</EOF>");
    }

    private Token number() {
        StringBuilder builder = new StringBuilder();

        do {
            builder.append(ch);
            consume();
        } while (isNumber());

        return new Token(Token.TokenType.NUMBER, builder.toString());
    }

    private void ws() {
        do {
            consume();
        } while (isWhiteSpace());
    }

    private boolean isWhiteSpace() {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }

    private boolean isNumber() {
        return ch >= '0' && ch <= '9';
    }

    private void consume() {
        ++p;

        if (p >= input.length()) {
            ch = EOF;
        } else {
            ch = input.charAt(p);
        }
    }
}
