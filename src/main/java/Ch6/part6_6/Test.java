package Ch6.part6_6;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Test {

    public Map<Boolean, List<Integer>> partitionPrimesWithCustom(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(new PrimeNumberCollector());
    }
}
