package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumber,int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

}
