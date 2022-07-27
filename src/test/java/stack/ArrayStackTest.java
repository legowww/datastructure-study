package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    public void ArrayStack() throws Exception {
        //given
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.push(300);
        stack.push(200);
        stack.push(100);
        stack.push(500);
        stack.print();

        Integer pop = stack.pop();
        System.out.println("pop = " + pop);

        //when

        //then
    }

}