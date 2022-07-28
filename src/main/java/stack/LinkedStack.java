package stack;

import list.Node;

public class LinkedStack<E> implements StackInterface<E>{
    private Node<E> topNode;
    private final E ERROR = null;

    public LinkedStack() {
        this.topNode = null;
    }

    @Override
    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);
    }

    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> temp = this.topNode;
            topNode = topNode.next;
            return temp.item;
        }
    }

    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        else {
            return topNode.item;
        }
    }

    @Override
    public boolean isEmpty() {
        return (topNode == null);
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
