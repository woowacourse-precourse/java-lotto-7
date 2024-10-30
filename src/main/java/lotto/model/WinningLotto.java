package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumberList;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumberList, int bonusNumber) {
        this.winningNumberList = winningNumberList;
        this.bonusNumber = bonusNumber;
    }
}
