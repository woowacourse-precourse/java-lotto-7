package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.common.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedTickets = generateAndDisplayTickets(purchaseAmount);
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);
        displayFinalResults(purchasedTickets, winningNumbersObject, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return inputView.inputBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Lotto> generateAndDisplayTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LottoConstants.TICKET_PRICE;
        List<Lotto> purchasedTickets = lottoService.purchaseTickets(ticketCount);
        outputView.displayPurchasedTickets(purchasedTickets);
        return purchasedTickets;
    }

    private void displayFinalResults(List<Lotto> purchasedTickets, WinningNumbers winningNumbers, int purchaseAmount) {
        Map<LottoRank, Integer> results = lottoService.analyzeLottoResults(purchasedTickets, winningNumbers);
        outputView.displayResults(results);

        double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
        outputView.displayProfitRate(profitRate);
    }
}
