package queue;

/**
 *  힙 삽입: O(logN)
 *  힙 삭제: O(logN)
 *  배열->힙: O(N)
 */

public class Heap<E extends Comparable> implements PQInterface<E> {
    private E[] A;
    private int numItems; //[1...numItems]
    private int length; //[1...length]

    public void print() {
        System.out.println("numItems=" + numItems + " length:" + length);
        for (int i = 1; i <= numItems; ++i) {
            System.out.println(i + "번째 배열:" + A[i]);
        }
    }

    public Heap(int arraySize) {
        A = (E[]) new Comparable[arraySize + 1];
        A[0] = null;    //0번 인덱스 사용안함(명시적 목적)
        length = A.length - 1;  //내가 실제로 사용할 수 있는 배열의 길이
        numItems = 0;
    }

    public Heap(E[] B, int numElements) {
        A = (E[]) new Comparable[numElements + 1];
        A[0] = null;
        for (int i = 0; i < numElements; ++ i) {
            A[i + 1] = B[i];
        }
        length = A.length - 1;  //내가 실제로 사용할 수 있는 배열의 길이
        numItems = numElements;
    }

    @Override
    public void insert(E newItem) throws Exception {
        // (4 < 5): [1...5]인덱스를 사용할 수 있는데 현재 [1...4]인덱스를 사용하고 있다. 이제 5번째 원소를 넣는다.
        if (numItems < length) {
            A[numItems + 1] = newItem; //처음 원소를 넣을 때를 생각하면, 1번 인덱스에 넣어야 한다.
            percolateBottomToTop(numItems + 1);
            numItems++;
        } else throw new PQException("HeapErr: Insert()-Overflow!");
    }

    private void percolateBottomToTop(int child) {
        int parent = child / 2;
        if (parent >= 1 && A[child].compareTo(A[parent]) > 0) {
            E temp = A[child];
            A[child] = A[parent];
            A[parent] = temp;
            percolateBottomToTop(parent);
        }
    }

    @Override
    public E deleteMax() throws Exception {
        if (!isEmpty()) {
            E max = A[1];
            A[1] = A[numItems];
            numItems--;
            percolateTopToBottom(1);
            return max;
        } else throw new PQException("HeapErr: Insert()-Overflow!");
    }

    private void percolateTopToBottom(int parent) {
        int child = (parent * 2);
        int rightChild = (parent * 2) + 1;

        if (child <= numItems) {
            if (rightChild <= numItems && A[child].compareTo(A[rightChild]) < 0) {
                child = rightChild;
            }
            if (A[parent].compareTo(A[child]) < 0) {
                E temp = A[parent];
                A[parent] = A[child];
                A[child] = temp;
                percolateTopToBottom(child);
            }
        }
    }

    @Override
    public E max() throws Exception {
        if (!isEmpty()) {
            return A[1];
        } else throw new PQException("HeapErr: Max()-Empty!");
    }

    //O(N)
    public void buildHeap() {
        if (numItems >= 2) {
            for (int i = numItems / 2; i >= 1; --i) {
                percolateTopToBottom(i);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        A = (E[]) new Comparable[A.length];
        A[0] = null;
        numItems = 0;
    }
}
