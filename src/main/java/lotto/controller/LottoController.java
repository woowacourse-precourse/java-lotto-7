package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.LottoGenerator;
import lotto.util.InputParser;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator generator;

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void play() {
        Money money = new Money(tryUntilSuccess(this::getMoney));

        generator.setMoney(money.getAmount());
        List<Lotto> lottos = generator.getLottos();

        outputView.printLottoBought(lottos);
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

        return InputParser.parseLong(validator.getMoney());
    }


}
