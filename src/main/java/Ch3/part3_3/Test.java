package Ch3.part3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader b = new BufferedReader(new InputStreamReader(System.in))){
            return p.process(b);
        }
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        String oneLine = test.processFile(b -> b.readLine());
        System.out.println(oneLine);
//        String twoLine = test.processFile(b -> b.readLine() + b.readLine());
    }
}
