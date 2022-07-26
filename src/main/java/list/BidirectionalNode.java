package list;

public class BidirectionalNode<E>{
    public E item;
    public BidirectionalNode<E> prev;
    public BidirectionalNode<E> next;

    public BidirectionalNode() {
        prev = next = null;
        item = null;
    }

    public BidirectionalNode(E item) {
        prev = next = null;
        this.item = item;
    }

    public BidirectionalNode(E item, BidirectionalNode<E> prevNode, BidirectionalNode<E> nextNode) {
        this.item = item;
        this.prev = prevNode;
        this.next = nextNode;
    }
}
