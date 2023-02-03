package Ch5.part5_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * flatmap => 하나의  stream 이 여러개의 stream 을 발생시킬때 사용한다.
 */
public class flatmap {

    // 실패한 사례
    public void case1(){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

//        List<String> collect = words.stream()
//                .map(w -> w.split("")) // --> 여기서 stream<String[]> 를 반환한다. stream<String> 을 반환하지 못하기 때문이다.
//                .distinct()
//                .collect(Collectors.toList());
    }

    // flatmap 을 사용해보자
    public void case2(){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

//        List<String> collect = words.stream().
//                map(w -> w.split("")).
//                flatMap(list -> Arrays.stream(list)).
//                distinct().collect(toList());

        List<Object> collect = words.stream().flatMap(w -> Arrays.stream(w.split(""))).distinct().collect(toList());

        System.out.println(collect);
    }

    // practice 연습 166p
    public void practice(){

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);

        // 실패
//        List<Stream<int[]>> collect = numbers1.stream().map(
//        i -> numbers2.stream().map(j -> {
//            return new int[]{i, j};
//        })).collect(Collectors.toList());

//        Stream<Stream<int[]>> streamStream = numbers1.stream().map(i -> numbers2.stream().map(j -> new int[]{i, j}));

        // 성공
        List<int[]> collect = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());

//        Stream<int[]> stream = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}));


        for (int[] ints : collect) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void main(String[] args) {
        flatmap flatmap = new flatmap();
        flatmap.case2();
        flatmap.practice();
    }

}
