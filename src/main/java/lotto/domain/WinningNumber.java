package lotto.domain;

public class WinningNumber {
    private static final String BONUS_NUMBER_CONFLICT_MESSAGE = "당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.";

    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumber(Lotto inputWinningNumbers, int inputBonusNumber) {
        winningNumbers = inputWinningNumbers;
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
            throw new IllegalArgumentException(BONUS_NUMBER_CONFLICT_MESSAGE);
        }
    }
}
