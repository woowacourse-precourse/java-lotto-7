package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;

public class ResultCalculator {
    private final Map<LottoRank, Integer> result = new HashMap<>();
    private int gain;

    public ResultCalculator(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        calculateResults(lottos, winningLotto, bonusNumber);
    }

    void calculateResults(Lottos lottos, Lotto winLotto, int bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.countMatchNumber(winLotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.getRank(matchCount, matchBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
            gain += rank.getPrizeAmount();
        }
    }

    double calculateRate(int money){
        return ((double) gain / money) * 100;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getGain() {
        return gain;
    }
}
