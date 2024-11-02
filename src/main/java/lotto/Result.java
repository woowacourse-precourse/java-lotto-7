package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Lotto[] userLottos;
    private final WinningNumbers winningNumbers;

    public Result(Lotto[] userLottos, WinningNumbers winningNumbers) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
    }

    public void printResult() {
        Map<String, Integer> matchCounts = countMatchesByRank();
        int totalPrize = calculateTotalPrize(matchCounts);

        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts.get("FIFTH"));
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts.get("FOURTH"));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts.get("THIRD"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts.get("SECOND"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts.get("FIRST"));

        double yield = calculateYield(totalPrize);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private Map<String, Integer> countMatchesByRank() {
        Map<String, Integer> matchCounts = new HashMap<>();
        matchCounts.put("FIRST", 0);
        matchCounts.put("SECOND", 0);
        matchCounts.put("THIRD", 0);
        matchCounts.put("FOURTH", 0);
        matchCounts.put("FIFTH", 0);

        for (Lotto lotto : userLottos) {
            int prize = calculatePrize(lotto);
            if (prize == 2000000000) matchCounts.put("FIRST", matchCounts.get("FIRST") + 1);
            else if (prize == 30000000) matchCounts.put("SECOND", matchCounts.get("SECOND") + 1);
            else if (prize == 1500000) matchCounts.put("THIRD", matchCounts.get("THIRD") + 1);
            else if (prize == 50000) matchCounts.put("FOURTH", matchCounts.get("FOURTH") + 1);
            else if (prize == 5000) matchCounts.put("FIFTH", matchCounts.get("FIFTH") + 1);
        }
        return matchCounts;
    }

    private int calculateTotalPrize(Map<String, Integer> matchCounts) {
        return matchCounts.get("FIRST") * 2000000000 +
                matchCounts.get("SECOND") * 30000000 +
                matchCounts.get("THIRD") * 1500000 +
                matchCounts.get("FOURTH") * 50000 +
                matchCounts.get("FIFTH") * 5000;
    }

    private int calculatePrize(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

        return Prize.getPrizeAmount((int) matchCount, bonusMatch);
    }

    private double calculateYield(int totalPrize) {
        int totalSpent = userLottos.length * 1000;
        return (double) totalPrize / totalSpent * 100;
    }
}




