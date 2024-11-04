package lotto;

import java.util.HashMap;
import java.util.List;

public class ResultLotto {
    private final HashMap<String, Integer> winningResult = new HashMap<>();
    private final int totalMoney;

    public ResultLotto(int totalMoney) {
        this.totalMoney = totalMoney;
        first();
    }

    private void first() {
        winningResult.put("3개 일치", 0);
        winningResult.put("4개 일치", 0);
        winningResult.put("5개 일치", 0);
        winningResult.put("5개 일치, 보너스 볼 일치", 0);
        winningResult.put("6개 일치", 0);
    }

    public void checkResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            if (matchCount == 6) {
                winningResult.put("6개 일치", winningResult.get("6개 일치") + 1);
            }
            if (matchCount == 5) {
                winningResult.put("5개 일치", winningResult.get("5개 일치") + 1);
                if (bonusMatch) {
                    winningResult.put("5개 일치, 보너스 볼 일치", winningResult.get("5개 일치, 보너스 볼 일치") + 1);
                }
            }
            if (matchCount == 4) {
                winningResult.put("4개 일치", winningResult.get("4개 일치") + 1);
            }
            if (matchCount == 3) {
                winningResult.put("3개 일치", winningResult.get("3개 일치") + 1);
            }
        }
    }

    private int countMatches(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateYield() {
        int totalWinningAmount = calculateTotalWinningAmount();
        return (totalWinningAmount / (double) totalMoney) * 100;
    }

    private int calculateTotalWinningAmount() {
        int totalWinningAmount = 0;
        totalWinningAmount += winningResult.get("6개 일치") * 2000000000;
        totalWinningAmount += winningResult.get("5개 일치, 보너스 볼 일치") * 30000000;
        totalWinningAmount += winningResult.get("5개 일치") * 1500000;
        totalWinningAmount += winningResult.get("4개 일치") * 50000;
        totalWinningAmount += winningResult.get("3개 일치") * 5000;
        return totalWinningAmount;
    }

    public HashMap<String, Integer> getwinningResult() {
        return winningResult;
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.get("3개 일치") + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.get("4개 일치")+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.get("5개 일치")+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get("5개 일치, 보너스 볼 일치")+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get("6개 일치")+ "개");
        System.out.println("총 수익률은 " + String.format("%.1f", calculateYield()) + "%입니다. ");
    }
}