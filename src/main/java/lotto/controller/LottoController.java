package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.model.strategy.NumberGenerationStrategy;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(NumberGenerationStrategy strategy) {
        this.lottoService = new LottoService(strategy);
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    /**
     * 로또 프로그램 실행 메서드
     */
    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> tickets = lottoService.purchaseLottoTickets(purchaseAmount);
        resultView.printLottoTickets(tickets);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, winningNumbers, bonusNumber);
        resultView.printResults(results);
    }
}