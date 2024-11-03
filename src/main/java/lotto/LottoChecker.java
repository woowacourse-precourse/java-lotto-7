package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoChecker {

    public void printResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultCount = initResultCount();
        calculateResults(lottos, winningNumbers, bonusNumber, resultCount);
        printStatistics(resultCount);
    }

    private Map<Rank, Integer> initResultCount() {
        Map<Rank, Integer> resultCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultCount.put(rank, 0);
        }
        return resultCount;
    }

    private void calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, Map<Rank, Integer> resultCount) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOfMatch(matchCount, hasBonus);
            resultCount.put(rank, resultCount.get(rank) + 1);
        }
    }

    private void printStatistics(Map<Rank, Integer> resultCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s (%s원) - %d개%n", rank.getDescription(), formatPrize(rank.getPrize()), resultCount.get(rank));
            }
        }
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize); // 1,500,000원 같은 형식으로 포맷팅
    }

    public void printProfitRate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private int calculateTotalPrize(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOfMatch(matchCount, hasBonus);
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
