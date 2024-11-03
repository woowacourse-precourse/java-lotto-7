package lotto.model;

import java.util.List;

public class Computer {
    private final Lotto winningLotto;
    private int bonusNumber;

    public Computer(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
