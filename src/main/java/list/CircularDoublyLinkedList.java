package list;

public class CircularDoublyLinkedList<E> implements ListInterface<E>{
    private BidirectionalNode<E> head;
    private int numItems;

    public CircularDoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode<>(null); //dummy head
        head.prev = head.next = head;
    }

    private BidirectionalNode<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = this.head;
            //numItems = 6
            //index(0,1,2) -> if
            //index(3,4,5) -> else
            if (index < numItems / 2) {
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;
                }
            }
            else {
                for (int i = numItems - 1; i >= index; i--) {
                    currNode = currNode.prev;
                }
            }
            return currNode;
        } else {
            return null;
        }
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= numItems) {
            BidirectionalNode<E> prevNode = getNode(index - 1);
            BidirectionalNode<E> newNode = new BidirectionalNode<>(x, prevNode, prevNode.next);
            newNode.next.prev = newNode;
            prevNode.next = newNode;
            numItems++;
        } else {
            throw new IndexOutOfBoundsException("index error");
        }
    }

    @Override
    public void append(E x) {
        BidirectionalNode<E> prevNode = head.prev;
        BidirectionalNode<E> newNode = new BidirectionalNode<>(x, prevNode, head);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            BidirectionalNode<E> currNode = getNode(index);
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            numItems--;
            return currNode.item;
        } else return null;
    }

    @Override
    public boolean removeItem(E x) {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i < numItems; ++i) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
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
        } else throw new IndexOutOfBoundsException("index error");
    }

    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E x) {
        BidirectionalNode<E> currNode = this.head;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0)
                return i;
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
        head.prev = head.next = head;
    }
}
