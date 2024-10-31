package lotto.domain;

public class AnswerNumbers {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private AnswerNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static AnswerNumbers from(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new AnswerNumbers(winningNumbers, bonusNumber);
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
