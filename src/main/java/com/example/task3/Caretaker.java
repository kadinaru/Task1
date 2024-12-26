package com.example.task3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {
    private final Deque<Memento> mementoList = new ArrayDeque<>();

    public void push(Memento state) {
        mementoList.push(state);
    }

    public Memento pop() {
        return mementoList.poll();
    }
}
