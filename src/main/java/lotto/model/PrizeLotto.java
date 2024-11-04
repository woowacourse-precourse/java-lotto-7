package lotto.model;

import java.util.List;

public class PrizeLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public PrizeLotto(Lotto prizeNumberLotto, int bonusNumber) {
        this.lotto = prizeNumberLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.lotto.getNumbers();
    }
}
