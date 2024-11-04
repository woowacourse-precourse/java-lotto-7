package lotto.service;

import lotto.model.LottoResult;

public class ProfitCalculatorService {

    public double calculateProfitPercentage(LottoResult result, int amount){
        double totalPrizeMoney = calculateTotalPrizeMoney(result);
        double roundToTwoDecimalPlaces = (totalPrizeMoney / amount) * 100;
        return mathRound(roundToTwoDecimalPlaces);
    }

    private int calculateTotalPrizeMoney(LottoResult result){
        int totalPrize = 0;
        for(int i=3;i<5;i++){
            if(result.getMatchCounts().get(i) != null){
                totalPrize += result.getMatchCounts().get(i)*result.getPrizeMoney().get(i);
            }
        }
        return totalPrize;
    }

    private double mathRound(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
