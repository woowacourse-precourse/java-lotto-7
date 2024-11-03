package lotto.domain;

import java.util.List;

public class MyLotto {
    private final Lotto myLotto;
    private final Integer bonusNumber;

    public MyLotto(final List<Integer> winningNumbers, final Integer bonusNumber) {
        this.myLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getMyLotto() {
        return myLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
