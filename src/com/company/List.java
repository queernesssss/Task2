package com.company;

public class List {
    private ListElement head;
    private ListElement tail;

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
    }

    public ListElement get(int k, int length) {
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

    public int[] toArray(int length) {
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
    }
}
