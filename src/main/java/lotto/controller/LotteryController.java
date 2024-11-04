package lotto.controller;

import lotto.domain.Money;
import lotto.domain.Tickets;
import lotto.domain.TotalResult;
import lotto.domain.WinningInfo;
import lotto.util.InputProcessor;
import lotto.view.OutputView;

public class LotteryController {

    private final InputProcessor inputProcessor = new InputProcessor();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = inputProcessor.createMoney();

        Tickets tickets = money.createTickets();
        outputView.printGeneratedTickets(tickets);

        WinningInfo winningInfo = inputProcessor.getWinningInfo();
        TotalResult totalResult = tickets.compareTicketsToWinningInfo(winningInfo);
        outputView.printResult(totalResult);

        double rateOfReturn = getRateOfReturn(money, totalResult);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private double getRateOfReturn(Money money, TotalResult totalResult) {
        long sumOfPrize = totalResult.calcSumOfPrize();

        return money.calcRateOfReturn(sumOfPrize);
    }
}
