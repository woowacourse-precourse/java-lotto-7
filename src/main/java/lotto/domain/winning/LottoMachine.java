package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoMachine {

    private final WinningNumbers winningNumbers;
    private final WinningStatus winningStatus = new WinningStatus();

    public LottoMachine(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningStatus checkWinningStatus(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonus());

            LottoStatus status = LottoStatus.of(matchCount, bonusMatch);
            if (status != LottoStatus.NONE) {
                winningStatus.addWinning(status);
            }
        }
        return winningStatus;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateYield(int purchaseAmount) {
        int totalPrize = winningStatus.calculateTotalPrize();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
