package com.datastructure.linkedlist.circle;


import com.datastructure.linkedlist.AbstractList;

/**
 * 双向循环链表
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //size = 0
        //index = 0
        if (index == size) { //往最后面添加元素
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);
            if (oldLast == null) {
                first = last;
                first.prev = first;
                first.next = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {//往最前面添加结点的情况
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            if (next == first) { //index = 0
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (node == first) { //index ==0
                first = next;
            }
            if (next == last) { //index == size - 1
                last = prev;
            }
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
//            string.append(node.element);
            string.append(node);
            node = node.next;
        }
//        while (node != null) {
//            node = node.next;
//        }
        string.append("]");
        return string.toString();
    }
}
