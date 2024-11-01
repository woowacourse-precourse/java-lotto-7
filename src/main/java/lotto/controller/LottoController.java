package lotto.controller;

import lotto.util.MoneyParser;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        long test = getMoney();
    }

    private long getMoney() {
        outputView.printMoneyRequest();
        MoneyValidator validator = new MoneyValidator(inputView.getUserInput());
        validator.validate();

        return MoneyParser.parseLong(validator.getMoney());
    }
}
