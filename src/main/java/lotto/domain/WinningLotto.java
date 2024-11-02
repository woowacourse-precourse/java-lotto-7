package lotto.domain;

import lotto.viewHandler.exception.DulplicateBonusNumber;

import java.util.Objects;

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
            throw new DulplicateBonusNumber("당첨 번호랑 겹치면 안됩니다.");
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
