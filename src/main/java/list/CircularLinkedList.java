package list;

public class CircularLinkedList<E> implements ListInterface<E> {
    private Node<E> tail;
    private int numItems;

    public CircularLinkedList() {
        numItems = 0;
        tail = new Node(-1); //dummy node
        tail.next = tail;
    }

    public void print() {
        Node<E> currNode = tail.next;
        for (int i = 0; i < numItems; ++i) {
            currNode = currNode.next;
            System.out.println(currNode.item + " ");
        }
        System.out.println("numItems=" + numItems);
        System.out.println("tail.item=" + tail.item);
        System.out.println("tail.next.item=" + tail.next.item);
        System.out.println("tail.next.next.item=" + tail.next.next.item);
        System.out.println();
    }

    private Node<E> getNode(int index) {
        //index=-1 => dummy head node
        if (index >= - 1 && index < numItems) {
            Node<E> currNode = tail.next;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else
            return null;
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(x, prevNode.next);
            prevNode.next = newNode;
            if (index == numItems) {
                tail = newNode;
            }
            numItems++;
        }
    }

    @Override
    public void append(E x) {
        Node<E> prevNode = tail;
        Node<E> newNode = new Node<>(x, tail.next);
        prevNode.next = newNode;
        tail = newNode;
        numItems++;
    }

    public void pop(E x) {
        if (!isEmpty()) {
            Node<E> prevNode = tail;
        }
    }


    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);
            E rItem = prevNode.next.item;
            prevNode.next = prevNode.next.next;
            if (index == numItems - 1)
                tail = prevNode;
            numItems--;
            return rItem;
        } else return null;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currNode = tail.next;
        Node<E> prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable<E>) currNode.item).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).item;
        } else return null;
    }

    @Override
    public void set(int index, E x) {
        if (index >= 0 && index < numItems) {
            getNode(index).item = x;
        } else {
            throw new IndexOutOfBoundsException("index error");
        }
    }

    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E x) {
        Node<E> currNode = tail.next;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable<E>)currNode.item).compareTo(x) == 0) return i;
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
        tail = new Node(-1);
        tail.next = tail;
    }
}
