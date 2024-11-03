package lotto.service;

import lotto.constant.Prize;

import java.util.Map;
import java.util.stream.Collectors;

public class BenefitService {
    private static BenefitService instance;
    private BenefitService() {
    }
    public static BenefitService getInstance(){
        if(instance == null){
            instance = new BenefitService();
        }
        return instance;
    }

    public Long calculateTotalPrize(Map<Prize, Integer> prizeResults){
        return prizeResults.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }

    public Double calculateBenefit(int purchasePrice, Long totalPrize){
        double benefit = (double) totalPrize / purchasePrice * 100;
        return Math.round(benefit * 10.0) / 10.0;
    }
}
