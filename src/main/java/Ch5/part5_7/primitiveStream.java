package Ch5.part5_7;

import common.Dish;
import common.Menu;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * API 기본형 특화 스트림을 사용하면
 * 박싱비용을 피할수있다.
 *
 * 스트림을 특화스트림으로 변환할때는 3가지 매서드가 주로사용된다.
 * mapToInt,Double,Long
 *
 * map 과 비슷한 기능을 수행하지만 Stream<T> 대신 특화된 스트림을 반환한다.
 */
public class primitiveStream {

    public void case1(){
//        Menu.menu.stream().map(Dish::getCalories).sum();  불가능

        Menu.menu.stream().
                mapToInt(Dish::getCalories).sum(); //가능

        IntStream intStream = Menu.menu.stream().mapToInt(Dish::getCalories); // Stream<Integer> 과는 다르다!

        //복원하기
        Stream<Integer> boxed = intStream.boxed();

    }

    public void case2(){
        OptionalInt max = Menu.menu.stream()
                .mapToInt(Dish::getCalories).max();

        // 값이 없다면 최대값 설정
        int i = max.orElse(1);

    }

    public void case3(){
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(intStream.count());
    }

    // 피타고라스의 수
    public void case4(){

        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed().
                flatMap(
                        a -> IntStream
                                .rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ); // IntStream 이므로 mapToObj 로 stream<R> 을위해 바꿔준다.

        stream.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] +", " + t[2]));

    }

    public static void main(String[] args) {
        primitiveStream primitiveStream = new primitiveStream();
        primitiveStream.case4();
    }
}
