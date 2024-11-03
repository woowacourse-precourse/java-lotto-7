package lotto.model;

import java.util.List;

public class Computer {
    private final Lotto winningLotto;

    public Computer(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
