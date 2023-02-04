package Ch6.part6_6;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.*;

/**
 * 성능향상후 Collector 를 만들어보자.
 */
public class PrimeNumberCollector implements Collector<Integer,Map<Boolean, List<Integer>>, Map<Boolean,List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean,List<Integer>>(){
            {
                put(true,new ArrayList<>());
                put(false,new ArrayList<>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean,List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true),candidate)).add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    private static boolean isPrime(List<Integer> primes,int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream().takeWhile( i -> i <= candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    // 아래를 좀더 성능개선시킬수있다.
    // 소수인지아닌지 판단할때 발견한 소수엣거만 찾아서 해줄수있다.
    // 그러나 아래와 같은방식은 Collector 가 이미 정형화되어있기에
    // 우리가 새로운 prime 만 모여있는 List 를 새로받아서 하려면
    // Collector 를 새로 만들어주어야한다.
    private static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot).takeWhile(i -> i <= candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
