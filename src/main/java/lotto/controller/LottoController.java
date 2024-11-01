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
        int totalPurchaseAmount = inputProcessor.getTotalPurchaseAmount();
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(totalPurchaseAmount);
        OutputView.displayLottoTickets(lottoTickets);

        Lotto winningLotto = inputProcessor.getWinningLotto();
        int bonusLottoNumber = inputProcessor.getBonusNumber(winningLotto);

        Map<LottoRank, Integer> lottoStatistics = lottoService.calculateWinningStatistics(lottoTickets, winningLotto, bonusLottoNumber);
        OutputView.displayWinningStatistics(lottoStatistics);

        long totalWinnings = lottoService.calculateTotalWinnings(lottoStatistics);
        double profitRate = lottoService.calculateProfitRate(totalWinnings, totalPurchaseAmount);
        OutputView.displayProfitRate(profitRate);
    }
}