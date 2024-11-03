package lotto.controller;

import java.util.List;
import lotto.service.WinningService;
import lotto.utils.NumberValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();

    public void start() {
        List<List<Integer>> lottos = processTicketPurchase();
        generateWinningNumbersAndDisplayResult(lottos);
        calculateAndPrintProfit();
    }

    private void generateWinningNumbersAndDisplayResult(List<List<Integer>> lottos) {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        winningService.winningStatistics(winningNumbers, lottos, bonusNumber);
        OutputView.printResult(winningService.getLottoResult());
    }

    private List<List<Integer>> processTicketPurchase() {
        int ticketQuantity = purchaseTicketQuantity();
        List<List<Integer>> lottos = lottoPurchaseResult(ticketQuantity);
        return lottos;
    }

    private void calculateAndPrintProfit() {
        String profit = winningService.getProfit();
        OutputView.printProfit(profit);
    }

    private List<List<Integer>> lottoPurchaseResult(int ticketQuantity) {
        OutputView.printTicketQuantity(ticketQuantity);
        List<List<Integer>> lottos = winningService.generateLottoNumber(ticketQuantity);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private int purchaseTicketQuantity() {
        InputView.printPurchaseMessage();
        return promptForValidTicketQuantity();
    }

    private List<Integer> inputWinningNumbers() {
        InputView.printWinningNumberMessage();
        return promptForValidWinningNumbers();
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumberMessage();
        return promptForValidBonusNumber(winningNumbers);
    }

    private int promptForValidBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.bonusNumberInput();
                NumberValidation.validateBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private List<Integer> promptForValidWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = InputView.winningNumberInput();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private int promptForValidTicketQuantity() {
        int ticketQuantity = 0;
        while (true) {
            try {
                int purchaseAmount = InputView.purchasePriceInput();
                ticketQuantity = winningService.buyTicket(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return ticketQuantity;
    }


}
