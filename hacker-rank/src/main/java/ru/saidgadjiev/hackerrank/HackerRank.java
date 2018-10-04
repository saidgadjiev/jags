package ru.saidgadjiev.hackerrank;

import java.util.*;

/**
 * Created by said on 28.09.2018.
 */
public class HackerRank {

    //Arrays: Left Rotation
    /*
        5 4
        1 2 3 4 5
        5 1 2 3 4
     */
    public int[] rotLeft(int[] a, int d) {
        int n = a.length;

        for (int i = 0; i < d; i++) {
            int j, temp;

            temp = a[0];

            for (j = 0; j < n - 1; j++) {
                a[j] = a[j + 1];
            }
            a[j] = temp;
        }

        return a;
    }

    /*
    Merge Sort: Counting Inversions
    */
    public long countInversions(int arr[]) {
        return mergeSort(arr, 0, arr.length / 2, arr.length / 2, arr.length);
    }

    private long mergeSort(int[] array, int start1, int end1, int start2, int end2) {
        long countInversions = 0;

        if (end1 - start1 > 1) {
            countInversions += mergeSort(array, start1, (end1 + start1) / 2, (end1 + start1) / 2, end1);
        }
        if (end2 - start2 > 1) {
            countInversions += mergeSort(array, start2, (end2 + start2) / 2, (end2 + start2) / 2, end2);
        }

        int[] merged = new int[end2 - start1];
        int mergedI = 0;
        int i = start1;
        int j = start2;

        while (i < end1 && j < end2) {
            if (array[i] <= array[j]) {
                merged[mergedI++] = array[i++];
            } else {
                merged[mergedI++] = array[j++];

                countInversions += end1 - i;
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

        return countInversions;
    }

    /*
        Frequency Queries
     */
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> elementFreq = new HashMap<>(queries.size());
        Map<Integer, Integer> freqCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> list : queries) {
            int i = list.get(0);
            int j = list.get(1);

            switch (i) {
                case 1:
                    if (freqCount.containsKey(elementFreq.get(j))) {
                        freqCount.put(elementFreq.get(j), freqCount.get(elementFreq.get(j)) - 1);
                    } else {
                        freqCount.put(elementFreq.get(j), 1);
                    }

                    if (elementFreq.containsKey(j)) {
                        elementFreq.put(j, elementFreq.get(j) + 1);
                    } else {
                        elementFreq.put(j, 1);
                    }

                    if (freqCount.containsKey(elementFreq.get(j))) {
                        freqCount.put(elementFreq.get(j), freqCount.get(elementFreq.get(j)) + 1);
                    } else {
                        freqCount.put(elementFreq.get(j), 1);
                    }

                    break;
                case 2:
                    if (elementFreq.containsKey(j)) {
                        if (freqCount.containsKey(elementFreq.get(j))) {
                            freqCount.put(elementFreq.get(j), freqCount.get(elementFreq.get(j)) - 1);
                        }
                        elementFreq.put(j, elementFreq.get(j) - 1);

                        if (freqCount.containsKey(elementFreq.get(j))) {
                            freqCount.put(elementFreq.get(j), freqCount.get(elementFreq.get(j)) + 1);
                        }

                        if (elementFreq.get(j) == 0) {
                            freqCount.remove(elementFreq.get(j));
                            elementFreq.remove(j);
                        }
                    }

                    break;
                case 3: {
                    if (freqCount.containsKey(j) && freqCount.get(j) > 0) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }

                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(HackerRank.freqQuery(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(3, 2));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(2, 5));
            add(Arrays.asList(3, 2));
        }}));
    }
}
