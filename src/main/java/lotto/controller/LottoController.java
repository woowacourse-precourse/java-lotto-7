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

    public void run() {
        LoggerUtils.logInfo("로또 프로그램 시작");

        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> tickets = lottoService.purchaseLottoTickets(purchaseAmount);
        LoggerUtils.logInfo("로또 티켓 발행 완료");

        resultView.printLottoTickets(tickets);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber();

        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, winningNumbers, bonusNumber);
        double yield = lottoService.calculateYield(purchaseAmount, results);

        LoggerUtils.logInfo("당첨 결과 계산 완료");
        resultView.printResults(results, yield);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber() {
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}