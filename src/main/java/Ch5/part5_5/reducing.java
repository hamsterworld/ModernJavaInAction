package Ch5.part5_5;

import java.util.Arrays;
import java.util.OptionalInt;

public class reducing {

    // 초기 값 있음
    public void case1(){
        int[] ints = {1, 2, 3, 4, 5};
        int reduce = Arrays.stream(ints).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    // 초기값 없음
    // 초기값이 없을땐 왜 Optional?
    // 데이터소스가 아무것도없다면 null 일수도 있기때문이다.
    public void case2(){
        int[] ints = {1, 2, 3, 4, 5};
        OptionalInt reduce1 = Arrays.stream(ints).reduce((a, b) -> a + b);
        System.out.println(reduce1.getAsInt());
    }

    // 최대값 최소값 찾기
    public void case3(){
        int[] ints = {1, 2, 3, 4, 5};
        OptionalInt reduce1 = Arrays.stream(ints).reduce(Integer::max);
        System.out.println(reduce1.getAsInt());
    }

    public static void main(String[] args) {
        reducing reducing = new reducing();
        reducing.case1();
        reducing.case2();
        reducing.case3();
    }


}
