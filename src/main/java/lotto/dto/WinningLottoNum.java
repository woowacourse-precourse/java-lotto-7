package lotto.dto;

import lotto.domain.Lotto;

public class WinningLottoNum {

    private Lotto winningLotto;
    private int bonusNum;

    public WinningLottoNum(Lotto winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
