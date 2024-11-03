package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class Calculator {
    private final LottoResultChecker lottoResultChecker;
    private final Money money;

    public Calculator(LottoResultChecker lottoResultChecker, Money money) {
        this.lottoResultChecker = lottoResultChecker;
        this.money = money;
    }

    public double calculateRateOfReturn(){

        int paymentAmount = money.getPaymentAmount();
        lottoResultChecker.findRank();
        Map<Rank, Integer> rankCount = lottoResultChecker.getRankCount();

        double profit = 0;
        for(Entry<Rank,Integer> entry : rankCount.entrySet()){
            int prize = entry.getKey().getPrize();
            Integer count = entry.getValue();
            profit += (prize * count);
        }

        return (profit /paymentAmount) * 100;
    }
}
