package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final Map<Rank, Integer> rankCountMap = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public void calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }
    }

    public void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.getMatchCount(), // 수정된 부분
                        rank.isRequiresBonus() ? ", 보너스 볼 일치" : "",
                        rank.getPrize(),
                        rankCountMap.get(rank));
            }
        }
    }
}
