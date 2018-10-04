package ru.saidgadjiev.sort.stack;

import java.util.Stack;

/**
 * Created by said on 30.09.2018.
 */
public class StackSort {

    public void sortRecursion(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();

            sortRecursion(stack);
            sortInsert(stack, temp);
        }
    }

    private void sortInsert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() >= x) {
            stack.push(x);
        } else {
            int temp = stack.pop();

            sortInsert(stack, x);

            stack.push(temp);
        }
    }

    public static Stack<Integer> sortTempStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>();

        while (!input.isEmpty()) {
            int tmp = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }

            tmpStack.push(tmp);
        }

        return tmpStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(1);
        stack.push(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(4);

        new StackSort().sortRecursion(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
