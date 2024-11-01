package lotto.controller;

import java.util.function.Supplier;
import lotto.model.Money;
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
        Money money = new Money(tryUntilSuccess(this::getMoney));


    }

    private <T> T tryUntilSuccess(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException errorMessage) {
                outputView.print(String.valueOf(errorMessage));
            }
        }
    }

    private long getMoney() {
        outputView.printMoneyRequest();
        MoneyValidator validator = new MoneyValidator(inputView.getUserInput());
        validator.validate();

        return MoneyParser.parseLong(validator.getMoney());
    }
}
