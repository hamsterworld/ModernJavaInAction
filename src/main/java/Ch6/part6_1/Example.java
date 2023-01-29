package Ch6.part6_1;

import Ch6.part6_0.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        List<Transaction> collect = transactions.stream().collect(Collectors.toList());

    }
}
