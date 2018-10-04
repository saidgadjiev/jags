package ru.saidgadjiev.sort.bubble;

/**
 * Created by said on 26.09.2018.
 */

/*  0 10 5 6 1 3 4 4
    0 5 6 1 3 4 4 10
    0 5 1 3 4 4 6 10
    0 1 3 4 4 5 6 10
*/
public class BubbleSort {

    public void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            boolean swapped = false;

            for (int j = 0; j < array.length - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    if (!swapped) {
                        swapped = true;
                    }
                    swap(array, j, j + 1);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void print(int[] array) {
        for (int a: array) {
            System.out.print(a);
            System.out.print(" ");
        }
    }

    private static void swap(int[] array, int i1, int i2) {
        int tmp = array[i2];

        array[i2] = array[i1];
        array[i1] = tmp;
    }

    public static void main(String[] args) {
        int array[] = new int[] { 0, 10, 5, 6, 1, 3, 4, 4 };

        new BubbleSort().sort(array);

        print(array);
    }
}
