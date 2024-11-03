package lotto.domain;

import lotto.domain.lotto.Lotto;

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

    public Rank compare(Lotto lotto) {
        return Rank.find(
                lotto.countMatchingNumbers(winningNumbers),
                lotto.hasBonusNumbers(bonusNumber.getBonusNumber())
        );
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
