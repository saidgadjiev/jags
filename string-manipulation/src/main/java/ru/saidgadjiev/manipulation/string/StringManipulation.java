package ru.saidgadjiev.manipulation.string;

import ru.saidgajiev.sort.quick.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by said on 30.09.2018.
 */
public class StringManipulation {

    public int jewel(String j, String s) {
        int result = 0;

        for (char ch: s.toCharArray()) {
            if (j.chars().anyMatch(value -> (char) value == ch)) {
                ++result;
            }
        }

        return result;
    }

    public Map<String, String> anagrams(String[] arr) {
        Map<String, String> result = new LinkedHashMap<>();

        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (isAnagrams(arr[i], arr[j])) {
                    result.put(arr[i], arr[j]);
                }
            }
        }

        return result;
    }

    private boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        QuickSort<Character> quickSort = new QuickSort<>();
        Character[] strChar1 = str1.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] strChar2 = str2.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        quickSort.sort(strChar1);
        quickSort.sort(strChar2);

        for (int i = 0; i < str1.length(); ++i) {
            if (!strChar1[i].equals(strChar2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String str1 = r.readLine();
        String str2 = r.readLine();

        if (str1.length() != str2.length()) {
            System.out.println(0);
            return;
        }

        int[] count = new int[256];
        int i;

        // For each character in input strings, increment count in
        // the corresponding count array
        for (i = 0; i <str1.length() && i < str2.length() ;  i++)
        {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        for (i = 0; i < 256; i++)
            if (count[i] > 0) {
                System.out.println(0);
                return;
            }

        System.out.println(1);
    }
}
