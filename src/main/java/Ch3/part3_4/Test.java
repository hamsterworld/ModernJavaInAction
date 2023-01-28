package Ch3.part3_4;


import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        IntPredicate function1 = i -> i % 2 == 0;
        boolean test = function1.test(1000); // <-- 오토박싱안된다. 파라미터가 int 임.
        System.out.println(test);

        Predicate<Integer> function2 = i -> i % 2 == 0;
        boolean test1 = function2.test(1000); // <-- 오토박싱된다. 파라미터가 T 즉, Object 이다.
        System.out.println(test1);
    }
}
