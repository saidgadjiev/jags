package ru.saidgadjiev.manipulation.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by said on 02.10.2018.
 */
public class Test1 {

    // Function that print all combinations of
    // balanced parentheses
    // open store the count of opening parenthesis
    // close store the count of closing parenthesis
    static void _printParenthesis(char str[], int pos, int n, int open, int close) {
        if (open == n && close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            if (open < n) {
                str[pos] = '(';
                _printParenthesis(str, pos + 1, n, open + 1, close);
            }
            if (close < open) {
                str[pos] = ')';
                _printParenthesis(str, pos + 1, n, open, close + 1);
            }
        }

    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n) {
        _printParenthesis(str, 0, n, 0, 0);
    }

    // driver program
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(r.readLine());

        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}