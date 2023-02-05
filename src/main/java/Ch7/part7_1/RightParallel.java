package Ch7.part7_1;

import java.util.stream.LongStream;

/**
 * 대부분의 병렬스트림의 문제는 공유된 상태를 바꾸는 알고리즘을 사용하기때문에 발생한다.
 *
 * 여기코드에서의 교훈!
 * 매우중요 병렬스트림을 올바르게 사용하려면 [공유된 가변상태]를 피해야 한다!
 *
 * 1. 확신이 서지 않으면 직접 측정하라.
 * 2. 박싱을 주의하라.
 * 3. 순차스트림보다 병렬스트림에서 성능이 떨어지는 연산들이 있다. ex)limit,findFirst
 * 4. 스트림에서 수행하는 전체 파이프라인 연산 비용을 고려하라.
 * 5. 소량의 데이터에서는 병렬스트림이 도움되지않는다.
 * 6. 스트림을 구성하는 자료구조가 적절한지 확인할것
 * 7. 중간연산,최종연산 비용을 살펴보라
 *
 *
 * ===========================
 * 데이터병렬은 매우 좋은 공부가 될것같다.
 * 그러나 현재 나에게 필요하지않으므로 패스해야될것같다.
 * 추가적으로 atomic 과관련해서 공부해보자.
 *
 */
public class RightParallel {

    public long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).forEach(accumulator::add);
        return accumulator.total;
    }

    public long parellelSideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static void main(String[] args) {
        RightParallel rightParallel = new RightParallel();
        long l = rightParallel.sideEffectSum(10_000_000L); // 50000005000000 이다.
        System.out.println(l);
        long l1 = rightParallel.parellelSideEffectSum(10_000_000L); // 50000005000000 가 나오지 않는다.
        System.out.println(l1);
        long l2 = rightParallel.parellelSideEffectSum(10_000_000L); // 50000005000000 가 나오지 않는다.
        System.out.println(l2);
    }

}
