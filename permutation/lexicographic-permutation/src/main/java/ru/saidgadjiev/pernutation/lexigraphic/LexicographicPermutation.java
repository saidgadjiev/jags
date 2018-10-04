package ru.saidgadjiev.pernutation.lexigraphic;

/**
 * Created by said on 04.10.2018.
 */
public class LexicographicPermutation {

    public void printPermutations(char[] arr) {
        int k = findK(arr);

        if (k == -1) {
            return;
        }
        int i = findI(arr, k);

        swap(arr, i, k);
        reverse(arr, k + 1, arr.length - 1);
        printArr(arr, arr.length);
        printPermutations(arr);
    }

    private void reverse(char[] arr, int l, int h) {
        while (l < h) {
            swap(arr, l, h);
            l++;
            h--;
        }
    }

    private int findK(char[] arr) {
        int k = -1;

        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] < arr[i + 1]) {
                k = i;
            }
        }

        return k;
    }

    private int findI(char[] arr, int k) {
        int i = -1;

        for (int p = k; p < arr.length; ++p) {
            if (arr[p] > arr[k]) {
                i = p;
            }
        }

        return i;
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
        char arr[] = {'A', 'B', 'C'};

        new LexicographicPermutation().printPermutations(arr);
    }
}
