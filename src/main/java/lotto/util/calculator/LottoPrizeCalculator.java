package lotto.util.calculator;

import lotto.BonusNumber;
import lotto.Lotto;
import lotto.LottoPrize;

import java.util.List;

public final class LottoPrizeCalculator {

    private LottoPrizeCalculator() {
    }

    public static double calculateProfit(long winningMoney, long originMoney) {
        double profitRate = (double) winningMoney / originMoney;
        return Math.round(profitRate * 1000) / 10.0;
    }

    public static LottoPrize calculatePrize(Lotto winningLotto, BonusNumber bonusNumber, Lotto targetLotto) {
        int matchNumberCount = winningLotto.countSameNumber(targetLotto.getNumbers());
        boolean isContainBonus = targetLotto.contains(bonusNumber.getNumber());
        return LottoPrize.match(matchNumberCount, isContainBonus);
    }

    public static long countPrizeCount(LottoPrize targetPrize, List<LottoPrize> prizes) {
        return prizes.stream()
                .filter(targetPrize::equals)
                .count();
    }

}
