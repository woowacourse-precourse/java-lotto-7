package lotto.controller;

import static lotto.global.exception.ExceptionHandler.getValidInput;

import lotto.domain.lotto.Lotto;
import lotto.domain.lottoMachine.BonusNumber;
import lotto.domain.lottoMachine.WinningLotto;
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
        WinningLotto winningLotto = createWinningLottoFromUserInput();
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

    private WinningLotto createWinningLottoFromUserInput() {
        Lotto winningLotto = getValidInput(() -> Lotto.from(view.inputWinningLotto()));
        BonusNumber bonusNumber = getValidInput(() -> BonusNumber.from(view.inputBonusNumber()));

        return WinningLotto.of(winningLotto, bonusNumber);
    }
}
