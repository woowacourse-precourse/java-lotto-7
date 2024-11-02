package controller;

import domain.Lotto;
import domain.Lottos;
import java.util.List;
import service.WinningService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        int purchaseAmount = InputView.purchasePriceInput();
        Lottos lottos = winningService.generateLottoNumber(purchaseAmount);
        OutputView.printTicketQuantity(winningService.getTicketQuantity());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        List<Integer> winningNumbers = InputView.winningNumberInput();
        int bonusNumber = InputView.bonusNumberInput();

        for (Lotto lotto : lottos.getLottos()) {
            winningService.winningStatistics(winningNumbers, lotto.getNumbers(), bonusNumber);
        }

        OutputView.printResult(winningService.getLottoResult());

        System.out.println(winningService.getProfit(purchaseAmount));
    }
}
