package ru.saidgadjiev.sort.selection;

/**
 * Created by said on 26.09.2018.
 */
/*
    0 10 5 6 1 3 4 4
    0 10 5 6 1 3 4 4
    0 1 5 6 10 3 4 4
    0 1 3 6 10 5 4 4
    0 1 3 4 10 5 6 4
    0 1 3 4 4 5 6 10
    0 1 3 4 4 5 6 10
 */
public class SelectionSort {

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            print(array);
            System.out.println();
            int min = i;

            for (int j = i + 1; j < array.length; ++j) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
    }

    private static void swap(int[] array, int i1, int i2) {
        int tmp = array[i2];

        array[i2] = array[i1];
        array[i1] = tmp;
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{0, 10, 5, 6, 1, 3, 4, 4};

        new SelectionSort().sort(array);

        print(array);
    }
}
