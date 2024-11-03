package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.common.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private int purchaseAmount;
    private int ticketCount;
    private List<Lotto> purchasedTickets;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        initializePurchaseAmount();
        generateAndDisplayTickets();
        displayFinalResults();
    }

    private void initializePurchaseAmount() {
        purchaseAmount = inputView.inputPurchaseAmount();
        ticketCount = purchaseAmount / LottoConstants.TICKET_PRICE;
    }

    private void generateAndDisplayTickets() {
        purchasedTickets = lottoService.purchaseTickets(ticketCount);
        outputView.displayPurchasedTickets(purchasedTickets);
    }

    private void displayFinalResults() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        Map<LottoRank, Integer> results = lottoService.analyzeLottoResults(purchasedTickets, winningNumbers, bonusNumber);
        outputView.displayResults(results);

        double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
        outputView.displayProfitRate(profitRate);
    }
}
