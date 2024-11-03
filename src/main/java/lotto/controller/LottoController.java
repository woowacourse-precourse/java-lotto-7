package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigInteger;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoMachine lottoMachine;

    public LottoController(Input input, Output output, LottoMachine lottoMachine) {
        this.input = input;
        this.output = output;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Lottos lottos = buyLottos();
    }

    private Lottos buyLottos() {
        try {
            Money money = getPurchaseMoney();
            Lottos lottos = lottoMachine.purchase(money);
            output.goToNext();
            output.showLottos(lottos);
            return lottos;
        } catch (IllegalArgumentException ex) {
            output.outputError(ex);
            return buyLottos();
        }
    }

    private Money getPurchaseMoney() {
        try {
            BigInteger amount = input.inputPurchaseAmount();
            return new Money(amount);
        } catch (IllegalArgumentException ex) {
            output.outputError(ex);
            return getPurchaseMoney();
        }
    }

}
