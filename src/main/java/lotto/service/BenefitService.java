package lotto.service;

import lotto.constant.Prize;

import java.util.Map;
import java.util.stream.Collectors;

public class BenefitService {
    public Long calculateTotalPrize(Map<Prize, Integer> prizeResults){
        return prizeResults.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }

    public static Double calculateBenefit(int purchasePrice, Long totalPrize){
        double benefit = (double) totalPrize / purchasePrice;
        return Math.round(benefit * 10.0) / 10.0;
    }
}
