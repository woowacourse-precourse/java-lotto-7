package controller;

import model.Lotto;
import model.LottoResult;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = issueLottos(purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        List<LottoResult> results = checkWinningResults(lottos, winningNumbers, bonusNumber);
        printResultsAndProfitRate(results, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = inputView.inputPurchaseCost();
                outputView.printTicketCount(purchaseAmount / 1000);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Lotto> issueLottos(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> lottos = lottoService.issueLottos(ticketCount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                lottoService.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                List<Integer> winningNumbers = inputWinningNumbers();
                lottoService.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<LottoResult> checkWinningResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lottoService.checkWin(lotto, winningNumbers, bonusNumber))
                .toList();
    }

    private void printResultsAndProfitRate(List<LottoResult> results, int purchaseAmount) {
        outputView.printResults(results);
        double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
