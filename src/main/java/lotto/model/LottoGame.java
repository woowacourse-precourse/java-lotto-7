package lotto.model;

import lotto.validation.LottoGameValidation;

import java.util.List;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        LottoGameValidation.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
