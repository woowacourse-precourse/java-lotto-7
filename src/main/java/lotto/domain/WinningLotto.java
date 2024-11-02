package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }
}
