package ru.saidgadjiev.bracket;

import java.util.Stack;

/**
 * Created by said on 29.09.2018.
 */
public class BracketSequence {

    //({[
    public boolean check(String sequence) {
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < sequence.length(); ++i) {
            char ch = sequence.charAt(i);

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    bracketStack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (bracketStack.isEmpty()) {
                        return false;
                    }
                    if (!check(sequence.charAt(i), bracketStack.pop())) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    private boolean check(char expect, char actual) {
        if (expect == ')' && actual != '(') {
            return false;
        }
        if (expect == '}' && actual != '{') {
            return false;
        }
        if (expect == ']' && actual != '[') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BracketSequence().check("({})"));
    }
}
