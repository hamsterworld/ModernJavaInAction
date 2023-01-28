package Ch5.part5_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class flatmap {

    // 실패한 사례
    public void case1(){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

//        List<String> collect = words.stream()
//                .map(w -> w.split("")) --> 여기서 stream<String[]> 를 반환한다. stream<String> 을 반환하지 못하기 때문이다.
//                .distinct()
//                .collect(Collectors.toList());
    }

    // flatmap 을 사용해보자
    public void case2(){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        List<String> collect = words.stream()
                .map(word -> word.split(""))
                .flatMap(wordslist -> Arrays.stream(wordslist))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    // practice 연습 166p
    public void practice(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);

        // 실패
//        List<Stream<int[]>> collect = numbers1.stream().map(i -> numbers2.stream().map(j -> {
//            System.out.println("처음");
//            return new int[]{i, j};
//        })).collect(Collectors.toList());

//        Stream<Stream<int[]>> streamStream = numbers1.stream().map(i -> numbers2.stream().map(j -> new int[]{i, j}));

        // 성공
        List<int[]> collect = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> {
            System.out.println(i);
            return new int[]{i, j}; }))
        .collect(Collectors.toList());

//        Stream<int[]> stream = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}));

        System.out.println(collect);
    }

    /*
        flatMap 은 쉽게
        stream<> 으로 평탄하게 한다고 보면된다.

        첫번째,
        stream<String[]> 가 나왔고
        flatMap 에 들어가서 String[]을 -> stream<String> 으로 쪼갠다
        이때 어떻게보면 맨처음 하나의 stream 에서 여러개의 stream 이 나온다고볼수있다.
        이런식으로 여러개로 쪼개서 하나의 stream 으로 평탄화한다고 보면된다 stream<stream<?>> 이런걸 stream 으로 변경시켜준다.

        두번째,
        map 으로하면 여러개의 stream<int[]> 가 맨처음 하나의 stream 에서 나온다.
     */

    public static void main(String[] args) {
        flatmap flatmap = new flatmap();
        flatmap.case2();
        flatmap.practice();
    }

}
