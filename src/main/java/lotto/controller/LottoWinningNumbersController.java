package lotto.controller;

import lotto.domain.LottoWinningNumbers;

import java.util.Set;

public class LottoWinningNumbersController {

    public LottoWinningNumbers determineLottoWinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers(winningNumbers, bonusNumber);
        return lottoWinningNumbers;
    }
}