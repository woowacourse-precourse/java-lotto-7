package lotto;

import java.util.List;

public class LottoResult {
    private final int[] prizeResults = new int[PrizeType.values().length];
    private final double rateOfReturn;

    public LottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        int totalWinnings = calculateTotalWinnings(purchasedLottos, winningNumbers, bonusNumber);
        this.rateOfReturn = calculateRateOfReturn(totalWinnings, purchasedLottos.size());
    }

    private int calculateTotalWinnings(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int totalWinnings = 0;
        for (Lotto lotto : purchasedLottos) {
            PrizeType prize = PrizeType.getPrizeType(lotto, winningNumbers, bonusNumber);
            prizeResults[prize.ordinal()]++;
            totalWinnings += prize.getPrize();
        }
        return totalWinnings;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private double calculateRateOfReturn(int totalWinnings, int lottoCount) {
        return Math.round((double) totalWinnings / (lottoCount * 1000) * 1000) / 10.0;
    }

    public int[] getResults() {
        return prizeResults;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
