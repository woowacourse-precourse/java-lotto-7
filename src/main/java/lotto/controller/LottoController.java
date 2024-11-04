package lotto.controller;

import static lotto.constant.ErrorMessage.PRINT_ERROR_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
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
            //로또 티켓 구매 수량
            int ticketCount = inputMiddleController.getValidatedBuyingAmount();

            //로또 티켓 발행
            LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
            LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(ticketCount,
                    lottoNumberGeneratorService);
            List<Lotto> issuedLotto = lottoTicketIssueService.issueLotto();
            outPutView.printBoughtLotto(issuedLotto);

            //당첨번호와 보너스 번호 발급
            WinningLotto winningLotto = inputMiddleController.getValidatedWinningLotto();

            //당첨통계 계산
            LottoMatchNumberService matchService = new LottoMatchNumberService(winningLotto);
            Map<WinningRank, Integer> results = matchService.calculateResults(issuedLotto);
            outPutView.printWinningStatistic(results);

            //수익률 계산
            double profitRate = CalculateProfitRateService.calculateProfitRate(results, ticketCount);
            outPutView.printProfitRate(profitRate);

        } catch (IllegalArgumentException e) {
            System.out.println(PRINT_ERROR_MESSAGE.getMessage() + e.getMessage());
        }
    }
}
