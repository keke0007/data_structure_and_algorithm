package com.datastructure.linkedlist;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(list.size(),40);
        list.remove(0);
        System.out.println(list);
    }
}
