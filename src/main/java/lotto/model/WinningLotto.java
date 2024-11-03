package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(List<Integer> numbers) {
        this.winningLotto =  new Lotto(numbers);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
