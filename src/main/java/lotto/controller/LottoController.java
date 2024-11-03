package lotto.controller;

import lotto.domain.*;
import lotto.domain.provider.DefinedNumberProvider;
import lotto.domain.provider.NumberProvider;
import lotto.domain.validator.RangeValidator;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigInteger;
import java.util.List;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoMachine lottoMachine;
    private final RangeValidator rangeValidator;

    public LottoController(Input input, Output output,
                           LottoMachine lottoMachine, RangeValidator rangeValidator) {
        this.input = input;
        this.output = output;
        this.lottoMachine = lottoMachine;
        this.rangeValidator = rangeValidator;
    }

    public void start() {
        Lottos lottos = buyLottos();
        output.goToNext();
        Draw draw = inputDraw();
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

    private Draw inputDraw() {
        try {
            Lotto winningNumbers = getWinningNumbers();
            output.goToNext();
            BonusNumber bonusNumber = getBonusNumber();
            return new Draw(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException ex) {
            output.outputError(ex);
            return inputDraw();
        }
    }

    private Lotto getWinningNumbers() {
        try {
            List<Integer> winningNumbers = input.inputWinningNumbers();
            NumberProvider drawNumberProvider = new DefinedNumberProvider(winningNumbers);
            return new Lotto(drawNumberProvider, rangeValidator);
        } catch (IllegalArgumentException ex) {
            output.outputError(ex);
            return getWinningNumbers();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            Integer number = input.inputBonusNumber();
            return new BonusNumber(number, rangeValidator);
        } catch (IllegalArgumentException ex) {
            output.outputError(ex);
            return getBonusNumber();
        }
    }

}
