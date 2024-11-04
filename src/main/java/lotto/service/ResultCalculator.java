package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.*;

public class ResultCalculator {
    private final Map<LottoRank, Integer> result = new HashMap<>();
    private int gain;

    public ResultCalculator(Lottos lottos, WinningLotto winningLotto) {
        calculateResults(lottos, winningLotto);
    }

    private void calculateResults(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.countMatchNumber(winningLotto.getLotto());
            boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.getRank(matchCount, matchBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
            gain += rank.getPrizeAmount();
        }
    }

    public double calculateRate(int money) {
        return ((double) gain / money) * 100;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
