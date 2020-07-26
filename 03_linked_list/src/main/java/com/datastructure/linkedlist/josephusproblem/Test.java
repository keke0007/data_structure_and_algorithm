package com.datastructure.linkedlist.josephusproblem;

public class Test {
    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <=8; i++) {
            list.add(i);
        }

        //指向头结点
        list.reset();
        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }

    public static void main(String[] args) {
        josephus();
    }
}
