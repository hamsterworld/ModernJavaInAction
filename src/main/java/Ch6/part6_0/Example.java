package Ch6.part6_0;


import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * 스트림으로 데이터를 수집해보자.
 */
public class Example {

    // 일반적으로 자바개발자들이 많이 사용하는 코드
    public void case1(){
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if(transactionsForCurrency == null){
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency,transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
    }

    // 굉장히 쉽게 해결할수있다.
    public void case2(){
        List<Transaction> transactions = new ArrayList<>();
        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));
    }



}
