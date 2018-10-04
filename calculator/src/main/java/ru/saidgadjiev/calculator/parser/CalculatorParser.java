package ru.saidgadjiev.calculator.parser;

import ru.saidgadjiev.calculator.lexer.CalculatorLexer;
import ru.saidgadjiev.calculator.lexer.Token;

/**
 * Created by said on 29.09.2018.
 */
public class CalculatorParser {

    private final CalculatorLexer lexer;

    private Token lookahead;

    public CalculatorParser(CalculatorLexer lexer) {
        this.lexer = lexer;

        consume();
    }

    public Double expression() {
        Double result = multExpression();

        while (true) {
            if (check(Token.TokenType.MINUS)) {
                result -= multExpression();
            } else if (check(Token.TokenType.PLUS)) {
                result += multExpression();
            }

            break;
        }

        return result;
    }

    private Double multExpression() {
        Double result = atom();

        while (true) {
            if (check(Token.TokenType.TIMES)) {
                result *= atom();
            } else if (check(Token.TokenType.DIV)) {
                result /= atom();
            }

            break;
        }

        return result;
    }

    private Double atom() {
        if (lookahead.getTokenType() == Token.TokenType.NUMBER) {
            Double result = Double.valueOf(lookahead.getValue());

            consume();

            if (check(Token.TokenType.EXPONENTIATION)) {
                if (lookahead.getTokenType() != Token.TokenType.NUMBER) {

                    throw new IllegalArgumentException("Expected NUMBER but found: " + lookahead.getTokenType());
                }
                Integer exp = Integer.valueOf(lookahead.getValue());

                consume();
                Double expValue = result;

                for (int i = 1; i < exp; ++i) {
                    result *= expValue;
                }
            }

            return result;
        } else if (check(Token.TokenType.BRACKET, "(")) {
            Double result = expression();

            match(Token.TokenType.BRACKET, ")");

            return result;
        }

        throw new IllegalArgumentException("Expected NUMBER or BRACKET ( but found: " + lookahead.getTokenType() + " " + lookahead.getValue());
    }

    private boolean check(Token.TokenType tokenType) {
        if (lookahead.getTokenType().equals(tokenType)) {
            consume();

            return true;
        }

        return false;
    }

    private boolean check(Token.TokenType tokenType, String value) {
        if (lookahead.getTokenType().equals(tokenType) && lookahead.getValue().equals(value)) {
            consume();

            return true;
        }

        return false;
    }

    private void match(Token.TokenType tokenType, String value) {
        if (lookahead.getTokenType().equals(tokenType) && lookahead.getValue().equals(value)) {
            consume();
        } else {
            throw new IllegalArgumentException("Expected " + tokenType + " with value " + value + " but found " + lookahead.getTokenType() + " with value " + lookahead.getValue());
        }
    }

    private void consume() {
        lookahead = lexer.nextToken();
    }

    public static void main(String[] args) {
        System.out.println(new CalculatorParser(new CalculatorLexer("")).expression());
    }
}
