package lotto.service;

import lotto.constant.LottoConfig.BonusCheck;
import lotto.constant.LottoConfig.Rank;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.model.LottosPrizeCount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoConfig.Rank.NOTHING;
import static lotto.constant.SystemConfig.HUNDRED_PERCENT;
import static lotto.constant.SystemConfig.ROUND_TO_FIRST_DECIMAL;
import static lotto.constant.SystemConfig.DEFAULT_VALUE;
import static lotto.constant.SystemConfig.COUNT_INCREMENT_VALUE;

public class LottoPrize {
    private final Lotto lotto;
    private final Bonus bonus;

    public LottoPrize(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Double calculateRateOfReturn(LottosPrizeCount lottosPrizeCount, Purchase purchase) {
        long totalPrizeMoney = lottosPrizeCount.getTotalPrizeMoney();
        int cost = purchase.getCost();
        double rateOfReturn = ((double) totalPrizeMoney / cost) * HUNDRED_PERCENT;
        return roundToFirstDecimal(rateOfReturn);
    }

    private static double roundToFirstDecimal(double rateOfReturn) {
        return Math.round(rateOfReturn * ROUND_TO_FIRST_DECIMAL) / ROUND_TO_FIRST_DECIMAL;
    }

    public LottosPrizeCount determineLottoPrizes(Lottos lottos) {
        Map<Rank, Integer> prizeCounts = new HashMap<>();

        for (Lotto ticket : lottos.getTickets()) {
            Rank rank = determineRank(lotto.getNumbers(), ticket.getNumbers());
            prizeCounts.put(rank, prizeCounts.getOrDefault(rank, DEFAULT_VALUE) + COUNT_INCREMENT_VALUE);
        }
        return new LottosPrizeCount(prizeCounts);
    }

    private Rank determineRank(List<Integer> prizeNumbers, List<Integer> userNumbers) {
        int matchCount = checkMatchCount(prizeNumbers, userNumbers);
        BonusCheck bonusCheck = checkBonusMatch(userNumbers);
        return Rank.matchRank(matchCount, bonusCheck);
    }

    private int checkMatchCount(List<Integer> prizeNumbers, List<Integer> userNumbers) {
        return (int) prizeNumbers.stream()
                .filter(userNumbers::contains)
                .count();
    }

    private BonusCheck checkBonusMatch(List<Integer> userNumbers) {
        if (userNumbers.contains(bonus.getNumber())) {
            return BonusCheck.TRUE;
        }
        return BonusCheck.FALSE;
    }
}
