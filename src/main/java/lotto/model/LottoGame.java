package lotto.model;

import java.util.List;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
