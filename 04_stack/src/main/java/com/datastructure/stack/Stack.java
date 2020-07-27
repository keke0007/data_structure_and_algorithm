package com.datastructure.stack;

import com.datastructure.stack.list.ArrayList;

/**
 * 采用继承的方式实现栈 不安全 父类的方法子类也可以使用
 *
 * 更改为采用组合实现
 * @param <E>
 */
public class Stack<E> /*extends ArrayList<E> */{

    private ArrayList<E> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * 添加元素
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top() {
        return list.get(list.size() - 1);
    }
}
