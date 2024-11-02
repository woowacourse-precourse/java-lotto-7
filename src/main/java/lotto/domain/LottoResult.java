package lotto.domain;

import lotto.util.LottoConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private final int purchaseAmount;
    private final WinningLotto winningLotto;
    private int totalPrize;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.rankCount = new HashMap<>();
        this.purchaseAmount = lottos.size() * LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();
        this.winningLotto = winningLotto;
    }

    private void calculateTotalRank(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            Rank rank = calculateLottoRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        });
    }

    private Rank calculateLottoRank(Lotto lotto) {
        int matchCount = winningLotto.countMatchNumbers(lotto);
        boolean matchBonus = winningLotto.matchBonusNumber(lotto);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private void calculateTotalPrize() {
        totalPrize =  rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
