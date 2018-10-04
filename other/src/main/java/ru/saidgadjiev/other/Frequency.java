package ru.saidgadjiev.other;

/**
 * Created by said on 30.09.2018.
 */
public class Frequency {

    public int stringFrequency(String str, String containsStr) {
        int frequency = 0;
        int m = str.length();
        int n = containsStr.length();

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;

            for (; j < n; ++j) {
                if (str.charAt(j + i) != containsStr.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                ++frequency;
            }
        }

        return frequency;
    }

    public int arrFrequency(int[] arr, int[] subArr) {
        int frequency = 0;
        int m = arr.length;
        int n = subArr.length;

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;

            for (; j < n; ++j) {
                if (arr[j + i] != subArr[j]) {
                    break;
                }
            }
            if (j == n) {
                ++frequency;
            }
        }

        return frequency;
    }

    public int listFrequency(LinkedList list, LinkedList subList) {
        int frequency = 0;
        int m = list.getSize();
        int n = subList.getSize();
        LinkedList.Node current = list.head;
        LinkedList.Node subListCurrent = subList.head;

        LinkedList.Node loopList = current;
        LinkedList.Node loopSubList = subListCurrent;

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;

            for (; j < n; ++j) {
                if (loopList.data != loopSubList.data) {
                    break;
                }

                loopList = loopList.next;
                loopSubList = loopSubList.next;
            }
            if (j == n) {
                ++frequency;
            }
            current = current.next;
            loopList = current;

            loopSubList = subListCurrent;
        }

        return frequency;
    }

    public static void main(String[] args) {
        System.out.println(new Frequency().stringFrequency("saaiaadaa", "aa"));
        System.out.println(new Frequency().arrFrequency(new int[]{10, 1, 4, 4, 5, 6, 4, 4}, new int[]{4, 4}));
        System.out.println(new Frequency().listFrequency(LinkedList.from( 1, 2, 4, 4, 5, 4, 4 ), LinkedList.from( 4, 4 )));
    }

    private static class LinkedList {

        Node head;

        int size;

        private void add(int data) {
            if (head == null) {
                head = new Node(data);
            } else {
                Node newNode = new Node(data);
                Node last = head;

                while (last.next != null) {
                    last = last.next;
                }

                last.next = newNode;
            }
            ++size;
        }

        int getSize() {
            return size;
        }

        static LinkedList from(int ... data) {
            LinkedList linkedList = new LinkedList();

            for (int v: data) {
                linkedList.add(v);
            }

            return linkedList;
        }

        private static class Node {

            int data;

            Node next;

            Node(int data) {
                this.data = data;
            }
        }
    }
}
