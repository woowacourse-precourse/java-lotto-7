package lotto.draw;

import lotto.vendingmachine.Lotto;

public class WinningLotto {
    final Lotto lottoNumbers;
    final int bonus;

    public WinningLotto(Lotto lottoNumbers, int bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }
}
