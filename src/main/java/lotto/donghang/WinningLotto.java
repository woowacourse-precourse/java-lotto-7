package lotto.donghang;

import lotto.vendingmachine.Lotto;

public class WinningLotto {
    public final Lotto lottoNumbers;
    public final int bonus;

    public WinningLotto(Lotto lottoNumbers, int bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }
}
