package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.lottoForm.WinningNumbers;

public class LottoController {

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public LottoController(Lottos lottos, WinningNumbers winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void evaluate() {
        lottos.compare(winningNumbers, bonusNumber);
    }
}
