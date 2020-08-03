package com.datastructure.queue.circle;

/**
 * 循环双端队列
 */
public class CircleDeque<E> {
    private int front;//对头元素的下标
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
//        elements[(front + size) % elements.length] = element;
        elements[index(size)] = element;
        size++;
    }

    //从队头出队
    public E deQueueFront() {
        E element = elements[front];
        elements[front] = null;
//        front = (front + 1) % elements.length;
        front = index(1);
        size--;
        return element;
    }

    //从队头入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    //从队尾出队
    public E deQueueRear() {
        int realIndex = index(size - 1);
        E real = elements[realIndex];
        elements[realIndex] = null;
        size--;
        return real;
    }

    //获取队列的头元素
    public E front() {
        return elements[front];
    }

    //获取队列的尾元素
    public E rear() {

        return elements[index(size - 1)];
    }

    /**
     * 索引的映射
     *
     * @return
     */
    private int index(int index) {
        index += front;
        if (index < 0) {
            return index + elements.length;
        }
        return index % elements.length;
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
        if (oldCapacity >= capacity) return;

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
