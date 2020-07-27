package com.datastructure.stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
