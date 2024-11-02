package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public List<Integer> lottoNums() {
        return lotto.numbers();
    }

    public BonusBall bonusBall() {
        return bonusBall;
    }
}
