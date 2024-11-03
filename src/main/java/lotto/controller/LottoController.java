package lotto.controller;

import java.util.List;
import lotto.service.WinningService;
import lotto.utils.NumberValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        int ticketQuantity = buyTicket();
        List<List<Integer>> lottos = purchaseLottoResult(ticketQuantity);

        List<Integer> winningNumbers = createWinningNumber();
        int bonusNumber = createBonusNumber(winningNumbers);

        winningService.winningStatistics(winningNumbers, lottos, bonusNumber);
        OutputView.printResult(winningService.getLottoResult());
        String profit = winningService.getProfit();
        OutputView.printProfit(profit);
    }

    private List<List<Integer>> purchaseLottoResult(int ticketQuantity) {
        OutputView.printTicketQuantity(ticketQuantity);
        List<List<Integer>> lottos = winningService.generateLottoNumber(ticketQuantity);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private int buyTicket() {
        InputView.printPurchaseMessage();
        return getValidateTicketQuantity();
    }

    private List<Integer> createWinningNumber() {
        InputView.printWinningNumberMessage();
        return getValidatedWinningNumbers();
    }

    private int createBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumberMessage();
        return getValidateBonusNumber(winningNumbers);
    }

    private int getValidateBonusNumber(List<Integer> winningNumbers) {
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

    private List<Integer> getValidatedWinningNumbers() {
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

    private int getValidateTicketQuantity() {
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
