package Ch3.part3_4_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {

        Function<BufferedReader,String> f = bufferedReader -> {
            try {
                return bufferedReader.readLine();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        };

        String apply = f.apply(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(apply);

    }
}
