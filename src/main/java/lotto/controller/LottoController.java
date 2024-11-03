package lotto.controller;

import static lotto.handler.Handler.repeatInputUntilValid;
import static lotto.view.InputView.getUserInput;
import static lotto.view.InputView.getUserInputByList;

import lotto.domain.LottoMachine;
import lotto.domain.Money;

public class LottoController {
    private LottoMachine lottoMachine;

    public LottoController() {
        lottoMachine = new LottoMachine();
    }

    public void start() {
        Money purchase = repeatInputUntilValid(() -> new Money(getUserInput()));

        repeatInputUntilValid(() -> lottoMachine.assignWinningNumbers(getUserInputByList()));
        repeatInputUntilValid(() -> lottoMachine.assignBonusNumber(getUserInput()));
    }
}
