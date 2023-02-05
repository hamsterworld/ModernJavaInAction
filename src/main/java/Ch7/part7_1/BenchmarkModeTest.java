package Ch7.part7_1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime) // 각 대상 매서드를 실행하는데 걸린 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2,jvmArgs = {"-Xms4G","-Xmx4G"}) // 4Gb 의 힙공간을 제공한 환경에서 두번 벤치마크를 수행해 결과의 신뢰성 확보
@State(Scope.Benchmark)
public class BenchmarkModeTest {

    public static final long N = 10_000_000L;

    @Benchmark
    public long sequentialSum(){
        return Stream.iterate(1L, i -> i+1).limit(N).reduce(0L,Long::sum);
    }

    @Benchmark
    public long iterativeSum(){
        long result = 0;
        for(long i = 1L; i <=N; i++){
            result += 1;
        }
        return result;
    }

    @Benchmark
    public long parallelSum(){
        return Stream.iterate(1L, i -> i+1).limit(N).parallel().reduce(0L,Long::sum);
    }

    @Benchmark
    public long rangedSum(){
        return LongStream.range(1,N).reduce(0L,Long::sum);
    }

    @Benchmark
    public long parallelRangedSum(){
        return LongStream.range(1,N).parallel().reduce(0L,Long::sum);
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크실행이후 가비지 컬렉터 시도
    public void tearDown(){
        System.gc();
    }

    public static void main(String[] args) throws RunnerException {
        Options build = new OptionsBuilder()
                .include(BenchmarkModeTest.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(1)
                .build();
        new Runner(build).run();
    }


}
