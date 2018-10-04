package ru.saidgadjiev.pernutation.lexigraphic;

/**
 * Created by said on 04.10.2018.
 */
public class Test {

    public void oneFrequency() {
        int arr[] = new int[] {1, 0, 1, 1, 0, 1, 1, 1};

        int i = 0;
        int max = 0;

        while (i < arr.length) {
            int value = arr[i];

            if (value != 1) {
                ++i;
                continue;
            }
            int frequency = 1;

            while (++i < arr.length && value == arr[i]) {
                ++frequency;
            }

            if (max < frequency) {
                max = frequency;
            }
        }

        System.out.print(max);
    }

    public void uniqueValues() {
        int arr[] = new int[] {1, 1, 2, 2, 3, 4, 5, 6};

        int i = 1;
        int curr = arr[0];

        while (i < arr.length) {
            int next = arr[i++];

            if (curr != next) {
                System.out.print(curr);
            }

            curr = next;
        }

        System.out.print(curr);
    }

    public void printBracketSequencesInLexicographic(char[] sequence, int pos, int open, int close, int n) {
        if (open == n && close == n) {
            for (int i = 0; i < sequence.length; ++i) {
                System.out.print(sequence[i]);
            }
            System.out.println();
        } else {
            if (open < n) {
                sequence[pos] = '(';
                printBracketSequencesInLexicographic(sequence, pos + 1, open + 1, close, n);
            }
            if (close < open) {
                sequence[pos] = ')';
                printBracketSequencesInLexicographic(sequence, pos + 1, open, close + 1, n);
            }
        }
    }

    public void printBracketSequences(char[] sequence, int pos, int open, int close, int n) {
        if (close == n) {
            for (int i = 0; i < sequence.length; ++i) {
                System.out.print(sequence[i]);
            }
            System.out.println();
        } else {
            if (open > close) {
                sequence[pos] = ')';
                printBracketSequences(sequence, pos + 1, open, close + 1, n);
            }
            if (open < n) {
                sequence[pos] = '(';
                printBracketSequences(sequence, pos + 1, open + 1, close, n);
            }
        }
    }

    public void isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println(false);
        } else {
            int count[] = new int[256];

            for (int i = 0; i < str1.length(); ++i) {
                --count[str1.charAt(i)];
                ++count[str2.charAt(i)];
            }
            boolean result = true;

            for (int i = 0; i < 256; ++i) {
                if (count[i] != 0) {
                    result = false;
                    break;
                }
            }

            System.out.println(result);
        }
    }

    public void lexicographicSequences(Character[] arr) {
        int k = -1;

        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] < arr[i + 1]) {
                k = i;
            }
        }

        if (k == -1) {
            return;
        }
        int i = -1;

        for (int p = k; p < arr.length; ++p) {
            if (arr[p] > arr[k]) {
                i = p;
            }
        }

        swap(arr, k, i);

        int l = k + 1, h = arr.length - 1;

        while (l < h) {
            swap(arr, l, h);

            ++l;
            --h;
        }
        print(arr);
        System.out.println();
        lexicographicSequences(arr);
    }

    public void mergeSort(Integer[] arr) {
        recursiveMergeSort(arr, 0, arr.length);
        print(arr);
    }

    private void recursiveMergeSort(Integer[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            recursiveMergeSort(arr, l, m);
            recursiveMergeSort(arr, m + 1, r);

            merge(arr, l, (l + r) / 2, r);
        }
    }

    private void merge(Integer[] arr, int i1, int i2, int i3) {
        Integer merge[] = new Integer[i3 - i1];
        int merged = 0, i = i1, j = i2;

        while (i < i2 && j < i3) {
            if (arr[i].compareTo(arr[j]) < 0) {
                merge[merged++] = arr[i++];
            } else {
                merge[merged++] = arr[j++];
            }
        }
        while (i < i2) {
            merge[merged++] = arr[i++];
        }
        while (j < i3) {
            merge[merged++] = arr[j++];
        }
        for (int p = i1, q = 0; p < i3; ++p, ++q) {
            arr[p] = merge[q];
        }
    }

    public void quickSort(Integer[] arr) {
        recursiveQuickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    private void recursiveQuickSort(Integer[] arr, int l, int r) {
        if (l < r) {
            int partition = partition(arr, l, r);

            recursiveQuickSort(arr, l, partition - 1);
            recursiveQuickSort(arr, partition + 1, r);
        }
    }

    private int partition(Integer[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; ++j) {
            if (arr[j] <= pivot) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);

        return i + 1;
    }

    private void subString(String str, String subString) {
        int n = str.length();
        int m = subString.length();
        boolean result = false;

        for (int i = 0; i <= n - m; ++i) {
            boolean check = true;

            for (int j = 0; j < m; ++j) {
                if (str.charAt(i + j) != subString.charAt(j)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result = true;
                break;
            }
        }

        System.out.println(result);
    }

    private void subList(Node list, Node subList) {
        int n = size(list);
        int m = size(subList);

        boolean result = false;

        Node headList = list;
        Node headSubList = subList;

        for (int i = 0; i <= n - m; ++i) {
            boolean check = true;
            Node listIterator = headList;
            Node subListIterator = headSubList;

            for (int j = 0; j < m; ++j) {
                if (listIterator.data != subListIterator.data) {
                    check = false;
                    break;
                }
                listIterator = listIterator.next;
                subListIterator = subListIterator.next;
            }
            headList = headList.next;
            if (check) {
                result = true;
                break;
            }
        }

        System.out.println(result);
    }

    private void reverse(Node list) {
        Node prev = null;
        Node curr = list;
        Node next = list;

        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node head = prev;

        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }

    private int size(Node list) {
        Node head = list;
        int size = 0;

        while (head != null) {
            head = head.next;
            ++size;
        }

        return size;
    }

    private<T> void swap(T[] arr, int i1, int i2) {
        T temp = arr[i1];

        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private<T> void print(T[] arr) {
        for(T ch: arr) {
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        new Test().oneFrequency();

        System.out.println();
        System.out.println();

        new Test().uniqueValues();

        System.out.println();
        System.out.println();

        char sequence[] = new char[6];
        new Test().printBracketSequencesInLexicographic(sequence, 0, 0, 0, 3);

        System.out.println();
        System.out.println();

        new Test().printBracketSequences(sequence, 0, 0, 0, 3);

        System.out.println();
        System.out.println();

        new Test().isAnagram("abc", "cab");

        System.out.println();
        System.out.println();

        new Test().lexicographicSequences(new Character[] {'A', 'B', 'C'});

        System.out.println();
        System.out.println();

        new Test().mergeSort(new Integer[] { 10, 5, 6, 1, 3, 4, 2, 2 });

        System.out.println();
        System.out.println();

        new Test().quickSort(new Integer[] { 2, 1 });

        System.out.println();
        System.out.println();

        new Test().subString("test", "es");

        System.out.println();
        System.out.println();

        Node list = new Node(1);

        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);

        Node subList = new Node(3);

        subList.next = new Node(4);

        new Test().subList(list, subList);

        System.out.println();
        System.out.println();

        new Test().reverse(list);
    }

    private static class Node {

        int data;

        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
