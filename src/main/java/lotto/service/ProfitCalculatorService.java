package lotto.service;

import lotto.constant.Rank;

import java.util.Map;

public class ProfitCalculatorService {
    private static ProfitCalculatorService instance;
    private ProfitCalculatorService() {
    }
    public static ProfitCalculatorService getInstance(){
        if(instance == null){
            instance = new ProfitCalculatorService();
        }
        return instance;
    }

    public Long calculateWinningAmount(Map<Rank, Integer> prizeResults){
        return prizeResults.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }

    public Double calculateBenefitRate(int purchasePrice, Long totalPrize){
        double benefit = (double) totalPrize / purchasePrice * 100;
        return Math.round(benefit * 10.0) / 10.0;
    }
}
