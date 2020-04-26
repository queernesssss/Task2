package com.company;

public class List {
    private ListElement head;
    private ListElement tail;
    private int length = 0;

    public List() { }

    public void add(int data) {
        ListElement el = new ListElement(null, null, data);
        if (head == null) {
            this.head = el;
            this.tail = head;
        } else {
            el.setPrev(tail);
            tail.setNext(el);
            tail = el;
        }
        length++;
    }

    public ListElement get(int k) {
        ListElement el;
        if (k > length / 2) {
            el = tail;
            int i = length;
            while (i != k) {
                el = el.getPrev();
                i--;
            }
        } else {
            el = head;
            int i = 0;
            while (i != k - 1) {
                el = el.getNext();
                i++;
            }
        }
        return el;
    }

    public void delete(int k) {
        ListElement el = get(k);
        if (el == head) {
            head = el.getNext();
            head.setPrev(null);
        } else {
            if (el == tail) {
                tail = el.getPrev();
                tail.setNext(null);
            } else {
                el.getPrev().setNext(el.getNext());
            }
        }
        length--;
    }

    public int length() {
        return length;
    }

    public int[] toArray() {
        int[] array = new int[length];
        ListElement el = head;
        int i = 0;
        while (el.getNext() != null) {
            array[i] = el.getData();
            el = el.getNext();
            i++;
        }
        array[i] = el.getData();
        return array;
    }

    public void clean() {
        head = null;
        tail = null;
        length = 0;
    }
}
