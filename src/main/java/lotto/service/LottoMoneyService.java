package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.constants.WinMoney;
import lotto.constants.WinRank;

public class LottoMoneyService {
    private final Map<WinRank, WinMoney> rankWithMoneyMap;

    public LottoMoneyService() {
        this.rankWithMoneyMap = new EnumMap<>(WinRank.class);
        rankWithMoneyMap.put(WinRank.FIRST, WinMoney.FIRST_MONEY);
        rankWithMoneyMap.put(WinRank.SECOND, WinMoney.SECOND_MONEY);
        rankWithMoneyMap.put(WinRank.THIRD, WinMoney.THIRD_MONEY);
        rankWithMoneyMap.put(WinRank.FOURTH, WinMoney.FOURTH_MONEY);
        rankWithMoneyMap.put(WinRank.FIFTH, WinMoney.FIFTH_MONEY);
    }

    public long getMoney(WinRank winRank) {
        return rankWithMoneyMap.get(winRank).getValue();
    }

    public double getRatioOfBenefit(LottoMatcher lottoMatcher, int validPurchasePrice) {
        long sum = 0;
        for (WinRank w : rankWithMoneyMap.keySet()) {
            sum += lottoMatcher.getResult(w) * rankWithMoneyMap.get(w).getValue();
        }
        return (double) sum / validPurchasePrice * 100;
    }
}
