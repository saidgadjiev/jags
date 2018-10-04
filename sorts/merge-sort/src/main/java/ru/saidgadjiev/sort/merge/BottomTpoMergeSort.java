package ru.saidgadjiev.sort.merge;

/**
 * Created by said on 26.09.2018.
 */

public class BottomTpoMergeSort {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            for (int j = 0; j + i < array.length; j += i * 2) {
                int end = j + 2 * i;

                merge(array, j, j + i, j + i, (end > array.length) ? array.length : end);
            }
        }
    }

    private void merge(int[] array, int start1, int end1, int start2, int end2) {
        for (int i = end2 - 1; i >= start2; i--) {
            int j, last = array[end1 - 1];

            for (j = end1 - 2; j >= start1 && array[j] > array[i]; j--)
                array[j + 1] = array[j];

            if (j != end1 - 2 || last > array[i]) {
                array[j + 1] = array[i];
                array[i] = last;
            }
        }
    }

    private static void print(int[] array, int start, int end) {
        for (int i = start; i < end; ++i) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{0, 10, 5, 6, 1, 3, 4, 4, 100, 75, 445, 12, 33 };

        new BottomTpoMergeSort().sort(array);
        print(array, 0, array.length);
    }
}
