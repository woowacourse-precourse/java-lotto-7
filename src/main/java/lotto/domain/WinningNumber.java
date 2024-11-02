package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> inputWinningNumbers, int inputBonusNumber) {
        winningNumbers = new Lotto(inputWinningNumbers);
        bonusNumber = isValidBonusNumber(inputBonusNumber);
    }

    public LottoRank calculateRank(Lotto lotto) {
        int correctCount = 0;
        for (int number : lotto.getNumbers()) {
            if (this.winningNumbers.contains(number)) {
                correctCount++;
            }
        }
        return LottoRank.setUpRankByCorrectCount(correctCount, correctBonus(lotto));
    }

    public boolean correctBonus(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private int isValidBonusNumber(int bonusNumber) {
        isAlreadyInWinningNumber(bonusNumber);
        return bonusNumber;
    }

    private void isAlreadyInWinningNumber(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.");
        }
    }
}
