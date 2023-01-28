package Ch4.part4_3.part4_3_1;

import java.util.List;
import java.util.stream.Stream;

/**
 * 스트림은 무조건 단한번만 소비할수있다.
 */
public class Test {

    public void test(List<String> list){
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println); // IllegalStateException 스트림은 이미 소비하였거나 닫힘.
    }
}
