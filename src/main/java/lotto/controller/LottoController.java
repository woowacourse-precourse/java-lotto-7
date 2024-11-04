package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Ticket;
import lotto.service.RankCounter;
import lotto.service.RevenuePercentCalculator;
import lotto.service.TicketGenerator;
import lotto.util.InputParser;
import lotto.validator.BonusValidator;
import lotto.validator.LottoValidator;
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
        Money money = tryUntilSuccess(() -> new Money(getMoney()));

        List<Ticket> tickets = getTickets(money);

        Lotto lotto = tryUntilSuccess(() -> new Lotto(getLotto()));
        Bonus bonus = tryUntilSuccess(() -> new Bonus(getBonus(), lotto.getNumbers()));

        getStatistics(tickets, lotto, bonus);
    }

    private <T> T tryUntilSuccess(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException errorMessage) {
                outputView.print(errorMessage.getMessage());
            }
        }
    }

    private long getMoney() {
        outputView.printMoneyRequest();
        String money = inputView.getUserInput();

        MoneyValidator validator = new MoneyValidator(money);
        validator.validate();

        return InputParser.parseLong(money);
    }

    private List<Ticket> getTickets(Money money) {
        generator.setMoney(money.getAmount());
        List<Ticket> tickets = generator.getTickets();
        outputView.printTicketNumbers(tickets);

        return tickets;
    }

    private List<Integer> getLotto() {
        outputView.printLottoRequest();
        String lotto = inputView.getUserInput();

        LottoValidator validator = new LottoValidator(lotto);
        validator.validate();

        return InputParser.parseListOfInteger(lotto);
    }

    private int getBonus() {
        outputView.printBonusRequest();
        String bonus = inputView.getUserInput();

        BonusValidator validator = new BonusValidator(bonus);
        validator.validate();

        return InputParser.parseInt(bonus);
    }

    private void getStatistics(List<Ticket> tickets, Lotto lotto, Bonus bonus) {
        RankCounter counter = new RankCounter(tickets, lotto, bonus);
        List<Long> rankCount = counter.getRankCount();

        RevenuePercentCalculator calculator = new RevenuePercentCalculator(rankCount);
        BigDecimal revenuePercent = calculator.getRevenuePercent();

        outputView.printStatHeader();
        outputView.printRanks(rankCount);
        outputView.printRevenuePercent(revenuePercent);
    }
}
