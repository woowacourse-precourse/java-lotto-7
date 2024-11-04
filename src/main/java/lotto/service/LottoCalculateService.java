package lotto.service;

import lotto.enums.WinningMoney;

import java.util.Map;

public class LottoCalculateService {

    public double calculateProfitRate(Map<String, Integer> lottoMatchCount, int totalInvestment) {
        int totalPrize = (lottoMatchCount.get("3") * WinningMoney.FIFTH_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get("4") * WinningMoney.FOURTH_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get("5") * WinningMoney.THIRD_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get("5B") * WinningMoney.SECOND_PRIZE_MONEY.getPrizeMoney()) +
                (lottoMatchCount.get("6") * WinningMoney.FIRST_PRIZE_MONEY.getPrizeMoney());
        double profitRate = (double) totalPrize / totalInvestment * 100;
        return profitRate;
    }
}
