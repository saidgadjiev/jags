package ru.saidgadjiev.sort.merge;

/**
 * Created by said on 27.09.2018.
 */
public class MergeSortExtraSpace {

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

        int[] merged = new int[end2 - start1];
        int mergedI = 0;
        int i = start1;
        int j = start2;

        while (i < end1 && j < end2) {
            if (array[i] > array[j]) {
                merged[mergedI++] = array[j++];
            } else {
                merged[mergedI++] = array[i++];
            }
        }

        while (i < end1) {
            merged[mergedI++] = array[i++];
        }
        while (j < end2) {
            merged[mergedI++] = array[j++];
        }

        for (int p = 0, q = start1; p < merged.length; ++p, ++q) {
            array[q] = merged[p];
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

        new MergeSortExtraSpace().sort(array);
        print(array, 0, array.length);
    }
}
