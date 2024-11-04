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

    /**
     * 순위에 해당하는 당첨금을 반환한다.
     *
     * @param winRank 당첨금을 알고싶은 순위 
     * @return 순위에 해당하는 당첨금
     */
    public long getMoney(WinRank winRank) {
        return rankWithMoneyMap.get(winRank).getValue();
    }

    /**
     * 로또의 수익률을 반환한다.
     *
     * @param lottoMatcher 로또를 맞춰본 결과
     * @param validPurchasePrice 로또 구입 금액
     * @return 수익률
     */
    public double getRatioOfBenefit(LottoMatcher lottoMatcher, int validPurchasePrice) {
        long sum = 0;
        for (WinRank w : rankWithMoneyMap.keySet()) {
            sum += lottoMatcher.getResult(w) * rankWithMoneyMap.get(w).getValue();
        }
        return (double) sum / validPurchasePrice * 100;
    }
}
