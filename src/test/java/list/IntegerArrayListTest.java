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
        //then
        list.print();
    }
}