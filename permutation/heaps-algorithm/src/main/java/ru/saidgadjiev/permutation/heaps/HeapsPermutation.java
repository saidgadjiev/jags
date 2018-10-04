package ru.saidgadjiev.permutation.heaps;

/**
 * Created by said on 04.10.2018.
 */
public class HeapsPermutation {

    public void printPermutations(char[] arr) {
        heapsPermutation(arr, arr.length, arr.length);
    }

    private void heapsPermutation(char[] arr, int size, int n) {
        if (size == 1) {
            printArr(arr, n);
        }

        for (int i = 0; i < size; ++i) {
            heapsPermutation(arr, size - 1, n);

            if (size % 2 == 1) {
                swap(arr, 0, size - 1);
            } else {
                swap(arr, i, size - 1);
            }
        }
    }

    private void swap(char[] array, int i1, int i2) {
        char tmp = array[i2];

        array[i2] = array[i1];
        array[i1] = tmp;
    }

    private void printArr(char a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        char arr[] = new char[]{'A', 'B', 'C'};

        new HeapsPermutation().printPermutations(arr);
    }
}
