package stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInterface<E>{
    private E stack[];
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayStack() {
        //자바 클래스에서는 제네릭 타입의 객체를 생성하지 못한다. (new E 불가능)
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1; //빈 상태일 때 -1값
    }

    public ArrayStack(int n) {
        stack = (E[]) new Object[n];
        topIndex = -1;
    }

    public void print() {
        if (!isEmpty()) {
            for (int i = 0; i <= topIndex; ++i) {
                System.out.println(stack[i]);
            }
            System.out.println();
        }
    }

    @Override
    public void push(E newItem) {
        if (isFull()) {
            throw new EmptyStackException();
        }
        else stack[++topIndex] = newItem;
    }

    private boolean isFull() {
        return (topIndex == stack.length - 1);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return ERROR;
        }
        return stack[topIndex--];
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return ERROR;
        }
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return (topIndex == -1);
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }
}
