package com.datastructure.queue.circle;

/**
 * 循环队列 (队列 : 尾进头出)
 * @param <E>
 */
public class CircleQueue<E> {
    private int front;//对头元素的下标
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    public void enQueue(E element) {
        ensureCapacity(size+1);
//        elements[(front + size) % elements.length] = element;
        elements[index(size)] = element;
        size++;
    }

    //出队
    public E deQueue() {
        E element = elements[front];
        elements[front] = null;
//        front = (front + 1) % elements.length;
        front = index(1);
        size--;
        return element;
    }

    //获取队头元素
    public E front() {
        return elements[front];
    }

    /**
     * 索引的映射
     *
     * @return
     */
    private int index(int index) {
        return (front + index) % elements.length;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(elements.length)
                .append(" size=").append(size)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 循环队列动态扩容
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity>=capacity) return;

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        //重置front
        front = 0;
    }
}
