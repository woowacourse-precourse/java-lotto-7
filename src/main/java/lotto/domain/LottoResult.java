package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public String calculateResults(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);

            if (results.containsKey(rank)) {
                results.put(rank, results.get(rank) + 1);
            }
        }

        return generateResultSummary();
    }

    private String generateResultSummary() {
        StringBuilder summary = new StringBuilder("---\n");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                summary.append(rank.getMatchCount())
                        .append("개 일치");

                if (rank.isRequiresBonus()) {
                    summary.append(", 보너스 볼 일치");
                }

                summary.append(" (")
                        .append(rank.getPrize())
                        .append("원) - ")
                        .append(results.get(rank))
                        .append("개\n");
            }
        }
        return summary.toString();
    }
}