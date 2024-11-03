package controller;

import java.util.List;
import service.WinningService;
import utils.NumberValidation;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        int ticketQuantity = buyTicket();
        List<List<Integer>> lottos = purchaseLottoResult(ticketQuantity);

        List<Integer> winningNumbers = createWinningNumber();
        int bonusNumber = createBonusNumber(winningNumbers);
/*
        for (Lotto lotto : lottos.getLottos()) {
            winningService.winningStatistics(winningNumbers, lotto.getNumbers(), bonusNumber);
        }


 */
        OutputView.printResult(winningService.getLottoResult());
        //String profit = winningService.getProfit(purchaseAmount);
        //OutputView.printProfit(profit);
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
