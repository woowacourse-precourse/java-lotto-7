package lotto.domain;

import lotto.viewHandler.exception.DulplicateBonusNumber;

import java.util.Objects;

import static lotto.viewHandler.exception.MyExceptionConstant.DUPLICATE_BONUS_NUMBER;

public class WinningLotto {
    private final Lotto winLotto;
    private final Integer bonusNumber;

    protected WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        this.winLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, Integer bonusNumber) {
        validation(winningLotto, bonusNumber);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static void validation(Lotto winningLotto, Integer bonusNumber) {
        if(winningLotto.getNumbers().stream().anyMatch(one -> Objects.equals(one, bonusNumber))){
            throw new DulplicateBonusNumber(DUPLICATE_BONUS_NUMBER);
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
