package lotto.domain;

import lotto.util.LottoConstant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private final int purchaseAmount;
    private final WinningLotto winningLotto;
    private int totalPrize;
    private double returnRate;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.rankCount = new HashMap<>();
        this.purchaseAmount = lottos.size() * LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();
        this.winningLotto = winningLotto;

        initializeRankCount();
        calculateTotalRank(lottos);
        calculateTotalPrize();
        calculateReturnRate();
    }

    private void initializeRankCount() {
        Arrays.stream(Rank.values())
                .forEach(i-> rankCount.put(i, 0));
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

    public void calculateReturnRate() {
        returnRate = (totalPrize * 100.0) / purchaseAmount;
    }

    public int getCountByRank(Rank rank) {
        return rankCount.get(rank);
    }

    public double getReturnRate() {
        return returnRate;
    }
}
