package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private Map<Integer, Integer> winningPrice = new HashMap<>();
    private Map<Integer, Integer> bonusWinningPrice = new HashMap<>();

    public int[] matching = new int[7];;
    public int[] bonusMatching = new int[7];;

    public LottoChecker(Map<Integer, Integer> winningPrice, Map<Integer, Integer> bonusWinningPrice) {
        this.winningPrice = winningPrice;
        this.bonusWinningPrice = bonusWinningPrice;
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

    public int calculateTotalWinningPrice() {
        int totalWinningPrice = 0;
        totalWinningPrice += matching[3] * winningPrice.get(3);
        totalWinningPrice += matching[4] * winningPrice.get(4);
        totalWinningPrice += matching[5] * winningPrice.get(5);
        totalWinningPrice += bonusMatching[5] * bonusWinningPrice.get(5);
        totalWinningPrice += matching[6] * winningPrice.get(6);
        return totalWinningPrice;
    }

    public String calculateProfitRate(int numberOfLottoes, int totalWinningPrice) {
        int purchaseAmount = numberOfLottoes * 1000;
        double profitRate = ((double) totalWinningPrice / purchaseAmount) * 100;
        return String.format("%.1f", Math.round(profitRate * 100) / 100.0);
    }

    public void printTotalReturnRate(int numberOfLottoes, int totalWinningPrice) {
        System.out.println("총 수익률은 "
                + calculateProfitRate(numberOfLottoes, totalWinningPrice)
                + "%입니다.");
    }

    public void printWinningInfo() {
        for (int i = 0; i <= 6; i++) {
            if (winningPrice.containsKey(i)) {
                System.out.println(i + "개 일치 (" + formatPrice(winningPrice.get(i)) + "원) - "
                        + matching[i] + "개");
            }
            if (bonusWinningPrice.containsKey(i)) {
                System.out.println(i + "개 일치, 보너스 볼 일치 ("
                        + formatPrice(bonusWinningPrice.get(i)) + "원) - "
                        + bonusMatching[i] + "개");
            }
        }
    }

    public void match(Lotto winningLotto, List<Lotto> lottoes, int bonusNumber) {
        for (Lotto lotto : lottoes) {
            int matchCount = numberMatch(winningLotto.getNumbers(), lotto.getNumbers());
            matching[matchCount]++;
            if (lotto.getNumbers().contains(bonusNumber) && matchCount == 5) {
                bonusMatching[5]++;
                matching[5]--;
            }
        }
    }

    public void result(Lotto winningLotto, List<Lotto> lottoes, int bonusNumber) {
        match(winningLotto, lottoes, bonusNumber);

        printWinningInfo();

        int totalWinningPrice = calculateTotalWinningPrice();

        printTotalReturnRate(lottoes.size(), totalWinningPrice);
    }


}
