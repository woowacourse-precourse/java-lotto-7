package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.service.InputProcessor;
import lotto.domain.Lotto;
import lotto.service.LottoTicketMachine;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputProcessor inputProcessor;
    private final LottoTicketMachine lottoTicketMachine;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputProcessor = new InputProcessor();
        this.lottoTicketMachine = new LottoTicketMachine();
    }

    public void run() {
        int totalPurchaseAmount = inputProcessor.getTotalPurchaseAmount();
        List<Lotto> lottoTickets = lottoTicketMachine.purchaseLottoTickets(totalPurchaseAmount);
        OutputView.displayLottoTickets(lottoTickets);

        Lotto winningNumbers = inputProcessor.getWinningNumbers();
        int bonusNumber = inputProcessor.getBonusNumber(winningNumbers);

        Map<LottoRank, Integer> lottoStats = lottoService.calculateLottoStats(lottoTickets, winningNumbers, bonusNumber);
        OutputView.displayLottoStats(lottoStats);

        long totalWinningAmount = lottoService.calculateTotalWinningAmount(lottoStats);
        double profitRate = lottoService.calculateProfitRate(totalWinningAmount, totalPurchaseAmount);
        OutputView.displayProfitRate(profitRate);
    }
}