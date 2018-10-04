package ru.saidgajiev.sort.quick;

/**
 * Created by said on 01.10.2018.
 */
public class QuickSort<T extends Comparable<T>> {

    // 10, 80, 30

    public void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; ++j) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(T[] array, int i1, int i2) {
        T tmp = array[i2];

        array[i2] = array[i1];
        array[i1] = tmp;
    }

    private void printArray(T arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 80, 30, 90, 40, 50, 70};

        QuickSort<Integer> quickSort = new QuickSort<>();

        quickSort.sort(arr);
        quickSort.printArray(arr);
    }
}
