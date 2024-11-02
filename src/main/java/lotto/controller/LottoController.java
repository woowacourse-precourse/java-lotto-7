package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Money;
import lotto.model.Ticket;
import lotto.service.TicketGenerator;
import lotto.util.InputParser;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final TicketGenerator generator;

    public LottoController(InputView inputView, OutputView outputView, TicketGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void play() {
        Money money = new Money(tryUntilSuccess(this::getMoney));

        generator.setMoney(money.getAmount());
        List<Ticket> tickets = generator.getTickets();

        outputView.printTicketNumbers(tickets);
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
