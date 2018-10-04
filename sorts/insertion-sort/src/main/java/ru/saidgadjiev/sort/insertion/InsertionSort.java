package ru.saidgadjiev.sort.insertion;

/**
 * Created by said on 26.09.2018.
 */
/*
    0 10 5 6 1 3 4 4
    0 10 5 6 1 3 4 4
    0 5 10 6 1 3 4 4
    0 5 6 10 1 3 4 4
    0 1 5 6 10 3 4 4
    0 1 3 5 6 10 4 4
    0 1 3 4 5 6 10 4
    0 1 3 4 4 5 6 10
 */
public class InsertionSort {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            print(array);
            System.out.println();
            int j = i - 1;
            int curr = array[i];

            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = curr;
        }
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{0, 10, 5, 6, 1, 3, 4, 4};

        new InsertionSort().sort(array);
        print(array);
    }
}
