package list;

import javax.swing.table.TableRowSorter;

public class LinkedList<E> implements ListInterface<E>{
    private Node<E> head;
    private int numItems;
    public LinkedList() {
        numItems = 0;
        head = new Node<>(null, null); //dummy node
    }

    public void print() {
        Node<E> currNode = head;
        for (int i = 0; i <= numItems - 1; ++i) {
            currNode = currNode.next;
            System.out.println(currNode.item + " ");
        }
        System.out.println();
    }

    @Override
    public void add(int index, E item) {
        if(index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(item, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        Node<E> newNode = new Node<>(item, null);
        prevNode.next = newNode;
        numItems++;
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            return null;
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else return null;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> prevNode, currNode = head;
        /*
                     prev     curr
            start    dummy    dummy
            i = 0    dummy    index 0
            i = 1    index0   index 1
         */
        for (int i = 0; i <= numItems - 1; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable<E>)currNode.item).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    //==연결 리스트의 k번째 원소 알려주기
    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else
            return null;
    }

    @Override
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = x;
        }
    }

    private final int NOT_FOUND = -12345;
    //==원소 x가 연결 리스트의 몇 번째 원소인지 알려주기==
    @Override
    public int indexOf(E x) {
        Node<E> currNode = head;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if(((Comparable<E>)currNode.item).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }
}
