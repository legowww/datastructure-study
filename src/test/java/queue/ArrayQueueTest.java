package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {


    @Test
    public void ArrayQueueTest() throws Exception {
        //given
        ArrayQueue<String> queue = new ArrayQueue<>(10);
        queue.enqueue("test1");
        queue.print();
        queue.enqueue("test2");
        queue.print();
        queue.enqueue("test3");
        queue.print();
        queue.enqueue("test4");
        queue.print();
        queue.enqueue("test5");
        queue.print();
        queue.dequeue();
        queue.print();

        //when

        //then
    }

}