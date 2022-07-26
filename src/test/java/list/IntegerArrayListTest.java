package list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ArrayListTest {

    @Test
    public void IntegerArrayList_테스트() throws Exception {
        //given
        IntegerArrayList list = new IntegerArrayList();
        list.add(0, 300);
        list.add(0, 200);
        list.add(0, 100);
        list.append(500);
        list.append(600);
        list.remove(3);
        list.removeItem(200);
        //then
        list.print();

        int i = list.indexOf(300);
        System.out.println("i = " + i);
    }

    @Test
    public void ArrayList_테스트() throws Exception {
        //given
        ArrayList<String> list = new ArrayList<>();
        //when
        list.add(0, "test");
        list.add(0, "sample");
        list.add(0, "String");
        list.removeItem("sample");
        list.append("LAST");
        //then
        list.print();
    }

    @Test
    public void LinkedList_테스트() throws Exception {
        //given
        LinkedList<Integer> list = new LinkedList<>();
        list.append(3);
        list.append(5);
        list.add(2, 2);
        list.add(0, 1);
        list.remove(1);
        list.removeItem(5);
        list.set(0, 100);
        list.add(2, 300);
        list.print();


        LinkedListIterator iter = new LinkedListIterator(list);
        while (iter.hasNext())
            System.out.print(iter.next().item + " -> ");
    }

   @Test
   public void CircularLinkedList_테스트() throws Exception {
       //given
       CircularLinkedList<Integer> list = new CircularLinkedList<>();
       list.add(0, 10);
       list.add(0, 20);
       list.add(2, 50);
       list.append(100);
       list.removeItem(50);

       list.print();

       int i = list.indexOf(100);
       System.out.println("i = " + i);
   }

    @Test
    public void CircularLinkedList_테스트2() throws Exception {
        //given
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(0, 10);
        Integer integer = list.get(0);
        System.out.println("integer = " + integer);
        list.print();



    }
}