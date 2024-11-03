package lotto.service;

import lotto.model.*;

import java.util.Map;

public class LottoResultCalculator {
    public void calculatePrizeResult(LottoBundle lottoBundle, LottoBonusNumber lottoBonusNumber, Lotto winningLotto, Cash cash) {
        Map<LottoPrizeType, Integer> lottoPrizes = lottoBundle.matchCountWithBonus(winningLotto, lottoBonusNumber);
        double benefit = calculateBenefit(lottoPrizes, lottoBundle, cash);
    }

    private double calculateBenefit(Map<LottoPrizeType, Integer> lottoPrizes, LottoBundle lottoBundle, Cash cash) {
        int totalPrizeCash = calculateTotalPrizeCash(lottoPrizes);
        if (totalPrizeCash != 0) {
            double benefit = (double) totalPrizeCash / lottoBundle.calculateTotalCost(cash);
            return Math.round(benefit * 100.0) / 100.0;
        }
        return 0;
    }

    private int calculateTotalPrizeCash(Map<LottoPrizeType, Integer> lottoPrizes) {
        int totalPrizeCash = 0;
        for (Map.Entry<LottoPrizeType, Integer> lottoPrize : lottoPrizes.entrySet()) {
            if (lottoPrize.getValue() != 0) {
                totalPrizeCash += lottoPrize.getKey().getPrizeAmount() * lottoPrize.getValue();
            }
        }
        return totalPrizeCash;
    }
}
