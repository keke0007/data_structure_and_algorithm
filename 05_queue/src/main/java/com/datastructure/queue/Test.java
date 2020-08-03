package com.datastructure.queue;

import com.datastructure.queue.circle.CircleQueue;

public class Test {
    public static void main(String[] args) {
       /*
       测试队列
       Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }*/
       /*
        测试双端队列
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(1);
        deque.enQueueFront(2);
        deque.enQueueRear(3);
        deque.enQueueRear(4);
        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }*/

       //测试循环队列以及循环队列的动态扩容
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 1; i < 10; i++) {
            circleQueue.enQueue(i);
        }

        for (int i = 1; i < 5; i++) {
            circleQueue.deQueue();
        }

        for (int i = 10; i < 20; i++) {
            circleQueue.enQueue(i);
        }

        System.out.println(circleQueue);

        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.deQueue());
        }
    }
}
