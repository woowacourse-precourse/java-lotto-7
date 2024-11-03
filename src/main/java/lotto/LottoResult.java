package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final Map<Rank, Integer> rankCountMap = new HashMap<>();
    private int totalPrize = 0;

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
            totalPrize += rank.getPrize(); // 총 상금 계산
        }
    }

    public void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");

        Rank[] orderedRanks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : orderedRanks) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.isRequiresBonus() ? ", 보너스 볼 일치" : "",
                        formatPrize(rank.getPrize()),
                        rankCountMap.get(rank));
            }
        }
    }

    public void printEarningsRate(int purchaseAmount) {
        double earningsRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningsRate);
    }

    private String formatPrize(int prize) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return formatter.format(prize);
    }
}
