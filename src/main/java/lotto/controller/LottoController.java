package lotto.controller;

import static lotto.global.exception.ExceptionHandler.getValidInput;

import lotto.domain.money.Money;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController(View view) {
        this.view = view;
    }

    public void start() {
        Money money = createMoneyFromUserInput();

//        Lottos lottos = money.buyLottos();
//        view.outputLottos(lottos);
//
//        WinningLotto winningLotto = view.inputWinningLottoNumber();
//        BonusNumber bonusNumber = view.inputBonusNumber();
//
//        getResults(lottos, winningLotto, bonusNumber);
//        view.outputResult(lottos.match(winningLotto, bonusNumber));
//
//        getProfitRate(money, lottos, winningLotto, bonusNumber);
//        view.outputProfitRate(money, lottos.match(winningLotto, bonusNumber));
    }

    private Money createMoneyFromUserInput() {
        return getValidInput(() -> Money.from(view.inputMoney()));
    }
}
