package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers,int bonusNumber) {
        this.winningLotto =  new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
