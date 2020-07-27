package com.datastructure.queue;

import com.datastructure.queue.list.LinkedList;

/**
 * 使用链表组合的方式实现队列
 * @param <E>
 */
public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     * @return
     */
    public E deQueue() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front() {
        return list.get(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }
}
