package lotto.service;

import lotto.model.LottoResult;

import java.util.Map;

public class ProfitCalculatorService {

    // 당첨 금액 총합/구입 금액*100
    public double resultProfit(LottoResult result, int amount){
        double totalPrizeMoney = addPrizeMoneyAll(result);
        double mathRoundBefore = (totalPrizeMoney / amount) * 100;
        return mathRound(mathRoundBefore);
    }

    // 당첨 금액 총합
    private int addPrizeMoneyAll(LottoResult result){
        int sum = 0;
        for(int i=3;i<5;i++){
            if(result.getMatchCounts().get(i) != null){
                sum += result.getMatchCounts().get(i)*result.getPrizeMoney().get(i);
            }
        }
        return sum;
    }

    // 소수 둘째자리 반올림
    private double mathRound(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
