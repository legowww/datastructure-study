package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    public void Heap() throws Exception {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(9);
        heap.insert(7);
        heap.insert(8);
        heap.insert(4);
        heap.insert(3);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.insert(8);
        heap.print();

        heap.clear();
        heap.insert(9);
        heap.insert(7);
        heap.insert(8);
        heap.insert(4);
        heap.insert(3);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.insert(8);
        heap.print();

        Integer max = heap.deleteMax();
        System.out.println("max = " + max);

        Integer max1 = heap.deleteMax();
        System.out.println("max = " + max1);

        heap.print();
    }

    @Test
    public void 배열을힙으로() throws Exception {
        Heap<Integer> heap = new Heap<>(new Integer[] {1, 2, 3, 50}, 4);

        heap.print();
        heap.buildHeap();
        heap.print();

    }
}