package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoRank;
import lotto.service.LottoService;
import lotto.utils.LoggerUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(
            LottoService lottoService,
            InputView inputView,
            ResultView resultView
    ) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    /**
     * 로또 프로그램 실행 메서드
     */
    public void run() {
        try {
            LoggerUtils.logInfo("로또 프로그램 시작");

            int purchaseAmount = inputView.inputPurchaseAmount();
            List<Lotto> tickets = lottoService.purchaseLottoTickets(purchaseAmount);
            LoggerUtils.logInfo("로또 티켓 발행 완료");

            resultView.printLottoTickets(tickets);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, winningNumbers, bonusNumber);
            LoggerUtils.logInfo("당첨 결과 계산 완료");

            resultView.printResults(results);

        } catch (Exception e) {
            LoggerUtils.logError("로또 프로그램 실행 중 오류 발생: " + e.getMessage());
            throw e;
        }
    }
}