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

    @Test
    public void minusZero() throws Exception {
        /**
         * 1. char 사칙연산 char = int 형변환
         * 2. charAt(index)은 char 반환
         * 3. '0' 의 아스키코드는 48
         *
         * charAt()으로 나온 문자열 7은 int 값 7이 아닌 char '7'이다.
         * '7'은 아스키 코드 55이다.
         * 그러므로 -'0'을 수행할 경우 55 - 48 = 7(int) 값이 나온다.
         */

        char zero = '0';
        System.out.println("zero = " + (int)zero);

        String postfix = "700";
        char c = postfix.charAt(0);
        System.out.println("문자 c = " + c);
        System.out.println("아스키 코드c = " + (int)c);

        int i = c - '0';
        System.out.println("둘다 int 7값 = " + i);
        System.out.println("둘다 int 7값 = " + (int)i);
    }
}