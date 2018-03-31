package com.g.prepare.hash;

import java.util.LinkedList;

public class Entry {

    Employee key;
    String value;
    Entry next;
    Entry(Employee k, String v) {
        key = k;
        value = v;
    }

    public Employee getKey() {
        return key;
    }

    public void setKey(Employee key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

}

