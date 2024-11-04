package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.domain.rank.Rank;

public class AnswerNumbers {

    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    private AnswerNumbers(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static AnswerNumbers from(WinningLotto winningLotto,
                                     BonusNumber bonusNumber) {
        return new AnswerNumbers(winningLotto, bonusNumber);
    }

    public Rank compare(Lotto lotto) {
        return Rank.find(
                lotto.countMatchingNumbers(winningLotto),
                lotto.contains(bonusNumber)
        );
    }
}
