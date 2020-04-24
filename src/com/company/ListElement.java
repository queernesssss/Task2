package com.company;

public class ListElement {
    private ListElement prev;
    private ListElement next;
    private int data;

    public ListElement(ListElement prev, ListElement next, int data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListElement getPrev() {
        return prev;
    }

    public ListElement getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
