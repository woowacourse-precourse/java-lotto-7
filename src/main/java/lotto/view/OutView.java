package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.ResultController;
import lotto.controller.StatisticsController;
import lotto.model.Result;

import java.util.List;

public class OutView {
    private final LottoController lottoController;
    private final PurchaseAmountController purchaseAmountController;
    private final ResultController resultController;
    private final StatisticsController statisticsController;

    public OutView(LottoController lottoController,
                   PurchaseAmountController purchaseAmountController,
                   ResultController resultController,
                   StatisticsController statisticsController) {
        this.lottoController = lottoController;
        this.purchaseAmountController = purchaseAmountController;
        this.resultController = resultController;
        this.statisticsController = statisticsController;
    }

    public void start() {
        int ticketCount = purchaseAmountController.processPurchase();

        List<List<Integer>> lottoTickets =
                lottoController.createLottoTickets(ticketCount);

        lottoController.displayLottoTickets(lottoTickets);

        Result result = resultController.processResult();

        statisticsController.updateStatistics(lottoTickets, result);
        String winningStatistics = statisticsController.getWinningStatistics(ticketCount);
        System.out.println(winningStatistics);
    }
}
