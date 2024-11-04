package lotto.domain;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initializeResults();
    }

    private void initializeResults() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public String calculateResults(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto);
            updateResultCount(rank);
        }
        return generateResultSummary();
    }

    private Rank determineRank(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private void updateResultCount(Rank rank) {
        if (results.containsKey(rank)) {
            results.put(rank, results.get(rank) + 1);
        }
    }

    private String generateResultSummary() {
        StringBuilder summary = new StringBuilder("---\n");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                summary.append(formatRankSummary(rank));
            }
        }
        return summary.toString();
    }

    private String formatRankSummary(Rank rank) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return String.format("%d개 일치%s (%s원) - %d개\n",
                rank.getMatchCount(),
                rank.isRequiresBonus() ? ", 보너스 볼 일치" : "",
                formatter.format(rank.getPrize()),
                results.get(rank));
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리 반올림
    }

    public String getProfitRateMessage(int purchaseAmount) {
        double profitRate = calculateProfitRate(purchaseAmount);
        return String.format("총 수익률은 %.1f%%입니다.", profitRate);
    }
}