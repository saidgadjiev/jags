package ru.saidgadjiev.map;

import java.util.LinkedHashMap;

/**
 * Created by said on 27.09.2018.
 */
public class LRUCache {

    private int size;

    private int cacheSize;

    private int capacity = 16;

    private Node[] nodes;

    private Node head;

    private Node tail;

    public LRUCache(int size) {
        nodes = new Node[capacity];

        cacheSize = size;
    }

    public void put(String key, Object value) {
        int hash = hash(key);

        if (size == cacheSize) {
            remove(tail.key);
        }

        if (nodes[hash] == null) {
            Node newNode = newNode(key, value);

            nodes[hash] = newNode;

            ++size;
        } else {
            Node curr = nodes[hash];

            while (curr.next != null && !curr.key.equals(key)) {
                curr = curr.next;
            }
            if (curr.key.equals(key)) {
                curr.value = value;
            } else {
                curr.next = newNode(key, value);

                ++size;
            }
        }

        if (capacity == size) {
            resize();
        }
    }

    public Object get(String key) {
        int hash = hash(key);
        Node curr = nodes[hash];

        if (curr == null) {
            return null;
        }

        while (curr != null && !curr.key.equals(key)) {
            curr = curr.next;
        }
        if (curr == null) {
            return null;
        }

        afterAccess(curr);

        return curr.value;
    }

    private int hash(String key) {
        return 0;
    }

    private void remove(String key) {
        remove(hash(key), key);
    }

    private void remove(int hash, String key) {
        if (nodes[hash] == null) {
            return;
        }
        Node curr = nodes[hash];
        Node prev = null;

        while (curr.next != null && !curr.key.equals(key)) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            //1. удаляем первый элемент
            nodes[hash] = curr.next;
        } else if (curr.next == null) {
            //2. Последний элемент
            prev.next = null;
        } else {
            //3. средний элемент
            prev.next = curr.next;
        }
        --size;

        afterRemove(curr);
    }

    private void afterRemove(Node node) {
        if (node.before == null && node.after == null) {
            //1. Первый единственный узел
            head = tail = null;
        } else if (node.after == null) {
            //1. Последний узел
            tail = node.before;
            tail.after = null;
        } else if (node.before == null) {
            //2. Первый узел
            head.after = node.after;
            node.after.before = head;
        } else {
            //3. Серединный узел
            node.before.after = node.after;
            node.after.before = node.before;
        }
    }

    private Node newNode(String key, Object value) {
        Node node = new Node(key, value);
        Node last = tail;

        tail = node;
        if (last == null)
            head = node;
        else {
            node.before = last;
            last.after = node;
        }

        return node;
    }

    private void afterAccess(Node node) {
        ++node.frequency;
        if (node.frequency <= head.frequency || node.key.equals(head.key)) {
            return;
        }

        if (node.before == null) {
            //1. Первый элемент
            return;
        }
        if (node.after == null) {
            //2. Перемещаем последний элемент
            tail = node.before;
            tail.after = null;
        } else {
            //3. Серединный узел
            node.before.after = node.after;
            node.after.before = node.before;
        }

        node.before = null;
        head.before = node;
        node.after = head;

        head = node;
    }

    private void resize() {
        Node[] tmp = nodes;

        capacity *= 2;
        nodes = new Node[capacity];

        for (Node node : tmp) {
            while (node != null) {
                put(node.key, node.value);

                node = node.next;
            }
        }
    }

    public int getSize() {
        return size;
    }

    private static class Node {

        String key;

        Object value;

        Node next;

        Node before;

        Node after;

        int frequency = 0;

        private Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache hashMap = new LRUCache(3);

        hashMap.put("test1", "1");
        hashMap.put("test2", "2");
        hashMap.put("test3", "3");
    }
}
