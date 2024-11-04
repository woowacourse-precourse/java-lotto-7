package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<String, Integer> prizeMap = Map.of(
            "3개 일치", 5000,
            "4개 일치", 50000,
            "5개 일치", 1500000,
            "5개 일치, 보너스 볼 일치", 30000000,
            "6개 일치", 2000000000
    );

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void printResult() {
        Map<String, Integer> resultCount = calculateResults();
        printStatistics(resultCount);
    }

    private Map<String, Integer> calculateResults() {
        Map<String, Integer> resultCount = new HashMap<>();
        resultCount.put("3개 일치", 0);
        resultCount.put("4개 일치", 0);
        resultCount.put("5개 일치", 0);
        resultCount.put("5개 일치, 보너스 볼 일치", 0);
        resultCount.put("6개 일치", 0);

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                resultCount.put("6개 일치", resultCount.get("6개 일치") + 1);
            } else if (matchCount == 5 && bonusMatch) {
                resultCount.put("5개 일치, 보너스 볼 일치", resultCount.get("5개 일치, 보너스 볼 일치") + 1);
            } else if (matchCount == 5) {
                resultCount.put("5개 일치", resultCount.get("5개 일치") + 1);
            } else if (matchCount == 4) {
                resultCount.put("4개 일치", resultCount.get("4개 일치") + 1);
            } else if (matchCount == 3) {
                resultCount.put("3개 일치", resultCount.get("3개 일치") + 1);
            }
        }

        return resultCount;
    }

    private void printStatistics(Map<String, Integer> resultCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrize = 0;

        String[] prizeOrder = {
                "6개 일치",
                "5개 일치, 보너스 볼 일치",
                "5개 일치",
                "4개 일치",
                "3개 일치"
        };

        for (String prizeInfo : prizeOrder) {
            int prizeAmount = prizeMap.get(prizeInfo);
            int count = resultCount.getOrDefault(prizeInfo, 0);
            totalPrize += count * prizeAmount;
            System.out.printf("%s (%d원) - %d개\n", prizeInfo, prizeAmount, count); // 디버깅 출력
        }

        double yield = calculateYield(totalPrize);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    double calculateYield(int totalPrize) {
        int totalSpent = lottos.size() * 1000;
        return (double) totalPrize / totalSpent * 100;
    }
}