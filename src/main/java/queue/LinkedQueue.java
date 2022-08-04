package queue;

import list.Node;

public class LinkedQueue<E> implements QueueInterface<E>{
    private Node<E> tail;
    private final E ERROR = null;
    private int numItems;


    public LinkedQueue() {
        tail = null; //처음 enqueue()가 수행되면 null 값이 newNode 로 교체된다. dummy node 는 사용하지 않았다.
        numItems = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node<E> currNode = tail.next;
            for (int i = 0; i < numItems; ++i) {
                System.out.print(currNode.item + "->");
                currNode = currNode.next;
            }
        }
    }

    @Override
    public void enqueue(E newItem) {
        Node<E> newNode = new Node<>(newItem);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("newItem=" + newItem + " tail=" + tail.item);
        numItems++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        }
        else {
            Node<E> front = tail.next;
            //원소가 하나뿐
            if (front == tail) {
                tail = null;
            } else {
                tail.next = front.next;
            }
            numItems--;
            return front.item;
        }
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return ERROR;
        }
        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return (tail == null);
    }

    @Override
    public void dequeueAll() {
        tail = null;
        numItems = 0;
    }
}
