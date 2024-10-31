package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCnt;
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount) {
        this.rankCnt = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
        initializeResult();
    }

    private void initializeResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCnt.put(rank, 0);
        }
    }

    private int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public void addWinningResult(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = countMatches(userLotto.getNumbers(), winningLotto.getNumbers());
        boolean hasBonus = matchCount == 5 && userLotto.getNumbers().contains(bonusNumber);

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);
        rankCnt.put(rank, rankCnt.get(rank) + 1);
    }

    private long calculateTotalPrize() {
        return rankCnt.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getAmount() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (totalPrize * 100.0) / purchaseAmount;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCnt);
    }

}
