package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.InputProcessor;
import lotto.model.Lotto;
import lotto.model.LottoTicketMachine;
import lotto.model.LottoRank;
import lotto.model.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputProcessor inputProcessor;
    private final LottoTicketMachine lottoMachine;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputProcessor = new InputProcessor();
        this.lottoMachine = new LottoTicketMachine();
    }

    public void run() {
        int totalPurchaseAmount = inputProcessor.inputPurchaseAmount();
        List<Lotto> lottoTickets = lottoMachine.purchaseLottos(totalPurchaseAmount);
        OutputView.displayLottoTickets(lottoTickets);

        Lotto winningLotto = inputProcessor.inputWinningLotto();
        int bonusLottoNumber = inputProcessor.inputBonusNumber(winningLotto);

        Map<LottoRank, Integer> lottoStatistics = lottoService.calculateWinningStatistics(lottoTickets, winningLotto, bonusLottoNumber);
        OutputView.displayWinningStatistics(lottoStatistics);

        displayFinalResult(lottoStatistics, totalPurchaseAmount);
    }

    private void displayFinalResult(Map<LottoRank, Integer> lottoStatistics, int purchaseAmount) {
        long totalWinnings = lottoService.calculateTotalWinnings(lottoStatistics);
        double profitRate = lottoService.calculateProfitRate(totalWinnings, purchaseAmount);
        OutputView.displayRateOfReturn(profitRate);
    }
}