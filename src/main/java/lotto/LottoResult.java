package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int ROUNDING_FACTOR = 1000;
    private static final double PRECISION = 10.0;
    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void calculateResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }

    public void printResults() {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), result.get(rank));
            }
        }
    }

    public double calculateYield(int purchaseAmount) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Math.round((totalPrize / (double) purchaseAmount) * ROUNDING_FACTOR ) / PRECISION;
    }
}