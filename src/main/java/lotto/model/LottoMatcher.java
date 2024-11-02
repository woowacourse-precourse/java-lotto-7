package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Prize;

public class LottoMatcher {
    private final Map<Prize, Integer> countByPrize;

    public LottoMatcher(Lottos lottos, WinningLotto winningLotto) {
        countByPrize = new HashMap<>();
        for (Lotto lotto : lottos.toList()) {
            Prize prize = Prize.getPrize(
                    winningLotto.countLottoNumberMatch(lotto),
                    winningLotto.hasBonusNumberIn(lotto)
            );

            if (prize == null) {
                continue;
            }

            countByPrize.put(prize, getPrizeCount(prize) + 1);
        }
    }

    public int getPrizeCount(Prize prize) {
        return countByPrize.getOrDefault(prize, 0);
    }

    public Money getEarned() {
        int earned = 0;

        for (Map.Entry<Prize, Integer> entry : countByPrize.entrySet()) {
            earned += entry.getKey().getEarning() * entry.getValue();
        }
        return new Money(earned);
    }
}
