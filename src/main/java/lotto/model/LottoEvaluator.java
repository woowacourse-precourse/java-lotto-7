package lotto.model;

import java.util.*;

public class LottoEvaluator {
    private int purchaseAmount;
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNum;
    private Map<Rank, Integer> lottoStats;
    private double profit;

    public LottoEvaluator(int purchaseAmount, List<Lotto> lottos, Lotto winningLotto, int bonusNum) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
        this.lottoStats = new HashMap<>();
        this.profit = 0;
    }

    public void evaluateResult() {
        for (Lotto lotto : lottos) {
            Set<Integer> matchedNumbers = new HashSet<>(lotto.getNumbers());
            matchedNumbers.retainAll(winningLotto.getNumbers());
            int matchCount = matchedNumbers.size();
            boolean hasBonus = matchedNumbers.contains(bonusNum);
            Rank rank = getRank(matchCount, hasBonus);
            lottoStats.put(rank, lottoStats.getOrDefault(rank, 0) + 1);
        }
    }

    public Rank getRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return Rank.FIRST;
        if (matchCount == 5 && hasBonus) return Rank.SECOND;
        if (matchCount == 5) return Rank.THIRD;
        if (matchCount == 4) return Rank.FOURTH;
        if (matchCount == 3) return Rank.FIFTH;
        return Rank.NONE;
    }

    public void calculateProfit() {
        for (Rank rank : lottoStats.keySet()) {
            profit += rank.getPrize() * lottoStats.get(rank);
        }
    }

    public double getProfitRate() {
        return profit / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getLottoStats() {
        return lottoStats;
    }

}
