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

            addSixMatchWinning(matchCount);
            addFiveMatchWithBonusWinning(matchCount, bonusMatch);
            addFiveMatchWinning(matchCount);
            addFourMatchWinning(matchCount);
            addThreeMatchWinning(matchCount);
        }
        return winningStatus;
    }

    private void addSixMatchWinning(int matchCount) {
        if (matchCount == 6) {
            winningStatus.addWinning("6개");
            return;
        }
    }

    private void addFiveMatchWithBonusWinning(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            winningStatus.addWinning("5개 + 보너스");
            return;
        }
    }

    private void addFiveMatchWinning(int matchCount) {
        if (matchCount == 5) {
            winningStatus.addWinning("5개");
            return;
        }
    }

    private void addFourMatchWinning(int matchCount) {
        if (matchCount == 4) {
            winningStatus.addWinning("4개");
            return;
        }
    }

    private void addThreeMatchWinning(int matchCount) {
        if (matchCount == 3) {
            winningStatus.addWinning("3개");
        }
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