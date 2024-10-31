package lotto.controller;

import lotto.domain.FortuneMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    InputView inputView;
    OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = inputView.getMoney();
        FortuneMachine fortuneMachine = new FortuneMachine();
        List<Lotto> lotto = fortuneMachine.buyLotto(money);
        outputView.showLottos(lotto);

    }
}
