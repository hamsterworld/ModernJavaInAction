package Ch7.part7_1;

import java.util.stream.Stream;

public class Example {

    // stream 을 이용한방법
    public long sequentialSum(long n){
        return Stream.iterate(1L, i -> i+1).limit(n).reduce(0L,Long::sum);
    }

    // 고전적인 방법
    public Long classicalSequentialSum(long n){
        long result = 0;
        for(long i = 1L; i <=n; i++){
            result += 1;
        }
        return result;
    }

    // ===============

    // 순차스트림을 병렬 스트림으로 변경해보자.
    public long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L,Long::sum);
    }

    // 과연 성능이 더좋아졋을까?
    // 항상 예측말고 소프트웨어는 직접 측정해봐야한다.


}
