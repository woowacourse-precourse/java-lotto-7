package lotto.service;

import lotto.enums.WinningMoney;

import java.util.Map;

public class LottoCalculateService {
    private final String THREE_MATCH = "3";
    private final String FOUR_MATCH = "4";
    private final String FIVE_MATCH = "5";
    private final String FIVE_BONUS_MATCH = "5B";
    private final String SIX_MATCH = "6";
    public double calculateProfitRate(Map<String, Integer> lottoMatchCount, int totalInvestment) {
        int totalPrize = (lottoMatchCount.get(THREE_MATCH) * WinningMoney.FIFTH_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get(FOUR_MATCH) * WinningMoney.FOURTH_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get(FIVE_MATCH) * WinningMoney.THIRD_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get(FIVE_BONUS_MATCH) * WinningMoney.SECOND_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get(SIX_MATCH) * WinningMoney.FIRST_PRIZE_MONEY.getPrizeMoney());
        double profitRate = (double) totalPrize / totalInvestment * 100;
        return profitRate;
    }
}
