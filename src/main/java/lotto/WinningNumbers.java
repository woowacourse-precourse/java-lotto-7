package lotto;

import lotto.store.Lotto;
import lotto.store.LottoNumber;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonus) {
        if(winningLotto.contains(bonus))
            throw new IllegalArgumentException("당첨 번호에 bonus 번호가 이미 존재합니다.");

        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }
}
