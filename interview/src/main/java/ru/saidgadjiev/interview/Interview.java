package ru.saidgadjiev.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by said on 27.09.2018.
 */
public class Interview {

    //Яндекс
    /*Максимальное повторение подряд идущих символов для каждого символа.
        "aafbaaaac"

        a:4
        f:1
        b:1
        c:1
     */
    public void maxFrequence(String str) {
        if (str == null) {
            return;
        }
        Map<Character, Integer> maxFrequenceMap = new LinkedHashMap<>();

        int i = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);
            int frequnce = 1;

            while (++i < str.length() && ch == str.charAt(i)) {
                ++frequnce;
            }

            if (maxFrequenceMap.containsKey(ch)) {
                if (maxFrequenceMap.get(ch) < frequnce) {
                    maxFrequenceMap.put(ch, frequnce);
                }
            } else {
                maxFrequenceMap.put(ch, frequnce);
            }
        }

        maxFrequenceMap.forEach((character, integer) -> System.out.println(character + ":" + integer));
    }

    public static void main(String[] args) {
        new Interview().maxFrequence("aafbaaaac");
    }
}
