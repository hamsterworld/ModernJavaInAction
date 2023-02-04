package Ch5.part5_8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 스트림을 만들어보자.
 */
public class makeStream {

    // 값으로 스트림 만들기
    public void case1(){
        Stream<String> modern = Stream.of("Modern", "Java", "In", "Action");
        modern.map(String::toUpperCase).forEach(System.out::println);
    }

    // null 이 될수있는 객체로 스트림 만들기
    public void case2(){

        // 기존에는 이렇게
        String home = System.getProperty("home");
        Stream<String> homeValueStream = home == null ? Stream.empty() : Stream.of("Modern", "Java", "In", "Action");

        // 지금
        Stream<String> home1 = Stream.ofNullable(System.getProperty("home"));

        Stream<String> stringStream = Stream.of("config", "user", "home").flatMap(key -> Stream.ofNullable(System.getProperty(key)));

    }

    // 배열로 스트림 만들기
    public void case3(){
        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }



    // 무한 스트림
    public void case5(){
        Stream.iterate(0, n->n+2).limit(10).forEach(System.out::println);
    }

    public void case6(){
        Stream.iterate(0,n -> n < 100,n -> n+4).forEach(System.out::println);
    }

    public void case7(){
        // case6 과 다른결과를 도출한다. 종료되지 않는 코드 forEach 에 도달하지못함.
        Stream.iterate(0,n ->{
            System.out.println(n);
            return n+4;
        } ).filter(n -> n< 100).forEach(n -> System.out.println(1));

        // 요렇게 사용해야한다.
        Stream.iterate(0,n -> n+4).takeWhile(n -> n < 100).forEach(System.out::println);
    }

    public void case8(){
        // 이것은 무한스트림이므로 sorted 가 안된다.
        Stream.generate(Math::random).sorted().limit(5).forEach(System.out::println);

        // 쇼트서킷을 사용해야한다.
        Stream.generate(Math::random).limit(5).sorted().forEach(System.out::println);

    }

    public static void main(String[] args) {
        makeStream makeStream = new makeStream();
        makeStream.case1();
//        makeStream.case7();
        makeStream.case8();
    }
}
