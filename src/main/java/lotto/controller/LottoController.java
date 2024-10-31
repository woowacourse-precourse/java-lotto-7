package lotto.controller;

import lotto.domain.FortuneMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Money money = inputView.getMoney();
        FortuneMachine fortuneMachine = new FortuneMachine();
        List<Lotto> lotto = fortuneMachine.buyLotto(money);

    }
}
