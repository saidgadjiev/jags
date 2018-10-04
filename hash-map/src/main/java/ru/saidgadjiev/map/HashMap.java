package ru.saidgadjiev.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by said on 27.09.2018.
 */
public class HashMap {

    private int currentSize = 16;

    private float threshold = 0.75f;

    private int size;

    private Node[] nodes = new Node[currentSize];

    public void put(String key, Object value) {
        if (threshold * currentSize >= size) {
            resize();
        }

        int hash = hash(key);

        if (nodes[hash] == null) {
            Node newNode = new Node(key, value);

            nodes[hash] = newNode;
        } else {
            Node head = nodes[hash];

            while (head.next != null) {
                head = head.next;
            }
            head.next = new Node(key, value);
        }
        ++size;
    }

    public Object get(String key) {
        int hash = hash(key);
        Node head = nodes[hash];

        while (head != null && !head.key.equals(key)) {
            head = head.next;
        }

        return head == null ? null : head.value;
    }

    private int hash(String key) {
        return key.hashCode() % currentSize;
    }

    private void resize() {
        Node[] tmp = nodes;

        currentSize *= 2;
        nodes = new Node[currentSize];

        for (Node node: tmp) {
            while (node != null) {
                put(node.key, node.value);

                node = node.next;
            }
        }
    }

    private static class Node {

        String key;

        Object value;

        Node next;

        private Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("test1", "1");
        hashMap.put("test2", "2");
        System.out.println(hashMap.get("test1"));
        System.out.println(hashMap.get("test2"));
    }
}
