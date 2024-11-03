package lotto;

import java.util.List;

public class LottoResult {
    private static final int[] PRIZES = {2000000000, 30000000, 1500000, 50000, 5000};
    private final int[] results = new int[5];
    private final double rateOfReturn;

    public LottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int totalWinnings = calculateTotalWinnings(purchasedLottos, winningNumbers, bonusNumber);
        this.rateOfReturn = calculateRateOfReturn(totalWinnings, purchasedLottos.size());
    }

    private int calculateTotalWinnings(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int totalWinnings = 0;
        for (Lotto lotto : purchasedLottos) {
            int prize = calculatePrize(lotto, winningNumbers, bonusNumber);
            totalWinnings += prize;
        }
        return totalWinnings;
    }

    private int calculatePrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        if (matchCount == 6) {
            results[0]++;
            return PRIZES[0];
        } else if (matchCount == 5 && hasBonus) {
            results[1]++;
            return PRIZES[1];
        } else if (matchCount == 5) {
            results[2]++;
            return PRIZES[2];
        } else if (matchCount == 4) {
            results[3]++;
            return PRIZES[3];
        } else if (matchCount == 3) {
            results[4]++;
            return PRIZES[4];
        }
        return 0;
    }

    private double calculateRateOfReturn(int totalWinnings, int lottoCount) {
        return Math.round((double) totalWinnings / (lottoCount * 1000) * 1000) / 10.0;
    }

    public int[] getResults() {
        return results;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
