package lotto.controller;

import static lotto.domain.factory.LottoFactory.generateLotto;
import static lotto.handler.Handler.repeatInputUntilValid;
import static lotto.view.InputView.getUserInput;
import static lotto.view.InputView.getUserInputByList;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;

public class LottoController {
    private LottoMachine lottoMachine;

    public LottoController() {
        lottoMachine = new LottoMachine();
    }

    public void start() {
        Money purchase = repeatInputUntilValid(() -> new Money(getUserInput()));
        List<Lotto> lottos = generateLotto(purchase);

        repeatInputUntilValid(() -> lottoMachine.assignWinningNumbers(getUserInputByList()));
        repeatInputUntilValid(() -> lottoMachine.assignBonusNumber(getUserInput()));
    }
}
