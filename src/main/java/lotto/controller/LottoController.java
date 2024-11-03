package lotto.controller;

import static lotto.global.exception.ExceptionHandler.getValidInput;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottoMachine.BonusNumber;
import lotto.domain.lottoMachine.Result;
import lotto.domain.lottoMachine.WinningLotto;
import lotto.domain.money.Money;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController(final View view) {
        this.view = view;
    }

    public void start() {
        Money money = createMoneyFromUserInput();

        Lottos lottos = buyLottos(money);
        WinningLotto winningLotto = createWinningLottoFromLottoAndBonusNumber();

        Result result = getLottoResults(lottos, winningLotto);
        getProfitRate(money, result);
    }

    private Money createMoneyFromUserInput() {
        return getValidInput(() -> Money.from(view.inputMoney()));
    }

    private Lottos buyLottos(final Money money) {
        Lottos lottos = money.buyLottos();
        view.outputLottos(lottos.getLottos());

        return lottos;
    }

    private WinningLotto createWinningLottoFromLottoAndBonusNumber() {
        Lotto lotto = getValidInput(this::createLottoFromUserInput);
        return getValidInput(() -> createBonusNumberFromUserInput(lotto));
    }

    private Lotto createLottoFromUserInput() {
        return Lotto.from(view.inputWinningLotto());
    }

    private WinningLotto createBonusNumberFromUserInput(final Lotto lotto) {
        BonusNumber bonusNumber = BonusNumber.from(view.inputBonusNumber());
        return WinningLotto.of(lotto, bonusNumber);
    }

    private Result getLottoResults(final Lottos lottos, final WinningLotto winningLotto) {
        Result result = Result.of(lottos, winningLotto);
        view.outputResult(result.getResults());

        return result;
    }

    private void getProfitRate(final Money money, final Result result) {
        view.outputProfitRate(money.caluteProfitRate(result.getReward()));
    }

}
