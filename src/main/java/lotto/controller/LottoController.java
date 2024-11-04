package lotto.controller;

import static lotto.constant.ErrorMessage.PRINT_ERROR_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningLotto;
import lotto.constant.WinningRank;
import lotto.service.CalculateProfitRateService;
import lotto.service.LottoMatchNumberService;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoTicketIssueService;
import lotto.view.OutPutView;

public class LottoController {
    private final OutPutView outPutView;
    private final InputMiddleController inputMiddleController;

    public LottoController(OutPutView outPutView, InputMiddleController inputMiddleController) {
        this.outPutView = outPutView;
        this.inputMiddleController = inputMiddleController;
    }

    public void run() {
        try {
            int ticketCount = inputMiddleController.getValidatedBuyingAmount();
            LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(ticketCount,
                    new LottoNumberGeneratorService());
            List<Lotto> issuedLotto = lottoTicketIssueService.issueLotto();
            outPutView.printBoughtLotto(issuedLotto);

            WinningLotto winningLotto = inputMiddleController.getValidatedWinningLotto();

            LottoMatchNumberService matchService = new LottoMatchNumberService(winningLotto);
            Map<WinningRank, Integer> results = matchService.calculateResults(issuedLotto);

            outPutView.printWinningStatistic(results);
            double profitRate = CalculateProfitRateService.calculateProfitRate(results, ticketCount);
            outPutView.printProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(PRINT_ERROR_MESSAGE.getMessage() + e.getMessage());
        }
    }
}
