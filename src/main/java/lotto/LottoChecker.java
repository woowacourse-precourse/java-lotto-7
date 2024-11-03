package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public Map<Integer, Integer> prizeMoney = new HashMap<>();
    public Map<Integer, Integer> bonusPrizeMoney = new HashMap<>();

    public int[] matchingCount;
    public int[] bonusMatchingCount;

    public LottoChecker(Map<Integer, Integer> prizeMoney, Map<Integer, Integer> bonusWinningPrizeMoney, int maximumMatchingCount) {
        this.prizeMoney = prizeMoney;
        this.bonusPrizeMoney = bonusWinningPrizeMoney;
        this.matchingCount = new int[maximumMatchingCount + 1];
        this.bonusMatchingCount = new int[maximumMatchingCount];
    }

    public int numberMatch(List<Integer> winningNumbers, List<Integer> numbers) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public String formatPrice(int price) {
        return String.format("%,d", price);
    }

    public int calculateTotalWinningPrizeMoney() {
        int totalWinningPrizeMoney = 0;
        totalWinningPrizeMoney += matchingCount[3] * prizeMoney.get(3);
        totalWinningPrizeMoney += matchingCount[4] * prizeMoney.get(4);
        totalWinningPrizeMoney += matchingCount[5] * prizeMoney.get(5);
        totalWinningPrizeMoney += bonusMatchingCount[5] * bonusPrizeMoney.get(5);
        totalWinningPrizeMoney += matchingCount[6] * prizeMoney.get(6);
        return totalWinningPrizeMoney;
    }

    public String calculateProfitRate(int numberOfLottoes, int totalWinningPrice) {
        int purchaseAmount = numberOfLottoes * 1000;
        double profitRate = ((double) totalWinningPrice / purchaseAmount) * 100;
        return String.format("%.1f", Math.round(profitRate * 100) / 100.0);
    }

    public void printTotalProfitRate(int numberOfLottoes, int totalWinningPrice) {
        System.out.println("총 수익률은 "
                + calculateProfitRate(numberOfLottoes, totalWinningPrice)
                + "%입니다.");
    }

    public void printWinningInfo() {
        for (int i = 0; i <= 6; i++) {
            if (prizeMoney.containsKey(i)) {
                System.out.println(i + "개 일치 (" + formatPrice(prizeMoney.get(i)) + "원) - "
                        + matchingCount[i] + "개");
            }
            if (bonusPrizeMoney.containsKey(i)) {
                System.out.println(i + "개 일치, 보너스 볼 일치 ("
                        + formatPrice(bonusPrizeMoney.get(i)) + "원) - "
                        + bonusMatchingCount[i] + "개");
            }
        }
    }

    public void match(Lotto winningLotto, List<Lotto> lottoes, int bonusNumber) {
        for (Lotto lotto : lottoes) {
            int matchCount = numberMatch(winningLotto.getNumbers(), lotto.getNumbers());
            matchingCount[matchCount]++;
            if (lotto.getNumbers().contains(bonusNumber) && matchCount == 5) {
                bonusMatchingCount[5]++;
                matchingCount[5]--;
            }
        }
    }

    public void result(Lotto winningLotto, List<Lotto> lottoes, int bonusNumber) {
        match(winningLotto, lottoes, bonusNumber);

        printWinningInfo();

        int totalWinningPrizeMoney = calculateTotalWinningPrizeMoney();

        printTotalProfitRate(lottoes.size(), totalWinningPrizeMoney);
    }


}
