package lotto.controller;

import lotto.domain.Money;
import lotto.domain.Tickets;
import lotto.domain.WinningInfo;
import lotto.service.LotteryService;
import lotto.util.InputProcessor;
import lotto.view.OutputView;

public class LotteryController {

    private final InputProcessor inputProcessor = new InputProcessor();
    private final OutputView outputView = new OutputView();
    private final LotteryService service = new LotteryService();

    public void run() {
        Tickets tickets = getTickets();
        WinningInfo winningInfo = inputProcessor.getWinningInfo();
    }

    private Tickets getTickets() {
        Money money = inputProcessor.createMoney();
        Tickets tickets = money.createTickets();
        outputView.printGeneratedTickets(tickets);

        return tickets;
    }
}
