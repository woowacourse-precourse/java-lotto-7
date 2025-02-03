package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.LottoStatisticsDto;

public class LottoStatistics {
    private final Map<LottoPrize, Integer> prizeCount;
    private final double rateOfReturn;

    public LottoStatistics(Map<LottoPrize, Integer> prizeCount, double rateOfReturn) {
        this.prizeCount = prizeCount;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoStatisticsDto createLottoStatisticsDto(LottoStatistics lottoStatistics) {
        return new LottoStatisticsDto(lottoStatistics.getPrizeCount(), lottoStatistics.getRateOfReturn());
    }

    public static LottoStatistics calcStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, Integer bonusNumber) {
        Map<LottoPrize, Integer> prizeCount = new HashMap<>();
        initPrizeCount(prizeCount);
        long sumOfPrizeMoney = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = calcMatchCount(purchasedLotto, winningLotto);
            boolean isBonusNumberMatched = purchasedLotto.contains(bonusNumber);
            LottoPrize prize = LottoPrize.valueOf(matchCount, isBonusNumberMatched);
            addPrize(prizeCount, prize);
            sumOfPrizeMoney += prize.getMoney();
        }
        double rateOfReturn =
                (double) sumOfPrizeMoney / (purchasedLottos.size() * LottoMachine.LOTTO_UNIT_PRICE) * 100.0;
        return new LottoStatistics(prizeCount, rateOfReturn);
    }

    private static void initPrizeCount(Map<LottoPrize, Integer> prizeCount) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            prizeCount.put(lottoPrize, 0);
        }
    }

    private static void addPrize(Map<LottoPrize, Integer> prizeCount, LottoPrize prize) {
        if (prize == LottoPrize.NOTHING) {
            return;
        }

        if (prizeCount.get(prize) == null) {
            prizeCount.put(prize, 1);
            return;
        }
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

    public static int calcMatchCount(Lotto purchasedLotto, Lotto winningLotto) {
        return (int) winningLotto.getNumbers().stream()
                .filter(purchasedLotto.getNumbers()::contains)
                .count();
    }

    public Map<LottoPrize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
