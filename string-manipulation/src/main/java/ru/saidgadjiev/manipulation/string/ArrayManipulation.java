package ru.saidgadjiev.manipulation.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by said on 02.10.2018.
 */
public class ArrayManipulation {

    public int maxFrequencyForOne(List<Integer> array) {
        int maxFrequency = 0;
        int i = 0;

        while (i < array.size()) {
            int value = array.get(i);

            if (value != 1) {
                ++i;
                continue;
            }
            int frequency = 1;

            while (++i < array.size() && value == array.get(i)) {
                ++frequency;
            }

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }

    public int maxFrequencyForOneWithoutExtraSpace() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(r.readLine());

        int maxFrequency = 0;
        int i = 0;

        while (i++ < count) {
            int value = Integer.parseInt(r.readLine());

            if (value != 1) {
                continue;
            }
            int frequency = 1;

            while (i++ < count && value == Integer.parseInt(r.readLine())) {
                ++frequency;
            }

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }

    public void unique(int[] arr) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(r.readLine());

        if (count > 0) {

            int i = 1;

            int value = Integer.parseInt(r.readLine());

            while (i++ < count) {
                int nextValue = Integer.parseInt(r.readLine());

                if (value != nextValue) {
                    System.out.println(value);
                }
                value = nextValue;
            }

            System.out.println(value);
        }
    }
}


