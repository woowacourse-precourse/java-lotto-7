package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
