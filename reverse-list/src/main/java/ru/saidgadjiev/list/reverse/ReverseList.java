package ru.saidgadjiev.list.reverse;

/**
 * Created by said on 27.09.2018.
 */
public class ReverseList {

    private Node head;

    private static class Node {

        String data;

        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    private void add(String data) {
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
    }

    private void print() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data);
            System.out.print(" ");
            node = node.next;
        }
    }

    private void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = head;

        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();

        reverseList.add("1");
        reverseList.add("2");
        reverseList.add("3");
        reverseList.add("4");
        reverseList.add("5");

        reverseList.print();

        reverseList.reverse();

        reverseList.print();
    }
}
