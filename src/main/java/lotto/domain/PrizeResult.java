package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {
    private final List<Lotto> lottos;
    private final WinningLotto winningLottos;
    private final Map<Prize, Integer> prizeCount = new HashMap<>();

    public PrizeResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLottos=winningLotto;
        initPrizeCount();
        calculatePrizeResult();
    }

    private void initPrizeCount() {
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    private void calculatePrizeResult() {
        for (Lotto lotto : lottos) {
            int matchCount = winningLottos.countMatchingNumbers(lotto);
            boolean bonusMatch = winningLottos.isBonusMatched(lotto);
            Prize prize = Prize.getPrize(matchCount, bonusMatch);

            prizeCount.put(prize, prizeCount.get(prize)+1);
        }
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }
}
