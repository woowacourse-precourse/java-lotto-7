package lotto.controller;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGroup;
import lotto.domain.WinningPrize;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoTicketGroup ticketGroup;
    private final WinningStatistics statistics;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.ticketGroup = new LottoTicketGroup();
        this.statistics = new WinningStatistics();
    }

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        generateLottoTickets(purchaseAmount);

        OutputView.printPurchasedTickets(ticketGroup);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        WinningPrize winningPrize = new WinningPrize(winningNumbers, bonusNumber);
        statistics.calculateCount(ticketGroup.getTickets(), winningPrize);

        OutputView.printWinningStatistics(statistics);
        OutputView.printProfit(statistics.calculateTotalProfit(purchaseAmount));
    }

    private void generateLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1_000;
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTicket ticket = new LottoTicket(lottoMachine.generateLotto());
            ticketGroup.addTicket(ticket);
        }
    }
}
