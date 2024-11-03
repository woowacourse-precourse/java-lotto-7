package controller;

import domain.Lotto;
import java.util.List;
import service.WinningService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        int ticketQuantity = buyTicket();
        List<List<Integer>> lottos = purchaseLottoResult(ticketQuantity);

        List<Integer> winningNumbers = InputView.winningNumberInput();
        int bonusNumber = InputView.bonusNumberInput();
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
