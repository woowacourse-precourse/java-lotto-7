package lotto.domain;

import static lotto.constants.Constants.HUNDRED;
import static lotto.constants.Constants.ONE;
import static lotto.constants.Constants.ZERO;
import static lotto.constants.Constants.ZERO_POINT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    private final List<Lotto> lottos;
    private Map<Winning, Integer> matchCounts;
    private int totalPrize;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
        this.matchCounts = new HashMap<>();
        this.totalPrize = ZERO;
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (Winning winning : Winning.values()) {
            matchCounts.put(winning, ZERO);
        }
    }

    public Map<Winning, Integer> getMatchCounts() {
        return matchCounts;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addToTotalPrize(int prize) {
        totalPrize += prize;
    }

    public void updateWinningStatistics(Winning winning) {
        matchCounts.put(winning, matchCounts.get(winning) + ONE);
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount == ZERO) {
            return ZERO_POINT;
        }
        return (double) totalPrize / purchaseAmount * HUNDRED;
    }
}
