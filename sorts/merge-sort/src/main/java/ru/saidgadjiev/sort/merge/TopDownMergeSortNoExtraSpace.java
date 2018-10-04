package ru.saidgadjiev.sort.merge;

/**
 * Created by said on 26.09.2018.
 */

public class TopDownMergeSortNoExtraSpace {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length / 2, array.length / 2, array.length);
    }

    private void mergeSort(int[] array, int start1, int end1, int start2, int end2) {
        if (end1 - start1 > 1) {
            mergeSort(array, start1, (end1 + start1) / 2, (end1 + start1) / 2, end1);
        }
        if (end2 - start2 > 1) {
            mergeSort(array, start2, (end2 + start2) / 2, (end2 + start2) / 2, end2);
        }

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

        new TopDownMergeSortNoExtraSpace().sort(array);
        print(array, 0, array.length);
    }
}
