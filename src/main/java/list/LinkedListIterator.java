package list;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Node> {
    private Node current;

    public LinkedListIterator(LinkedList list) {
        current = list.getNode(-1);
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public Node next() {
        return current = current.next;
    }
}
