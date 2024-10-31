package lotto.controller;

import static lotto.constant.LottoGameRule.LOTTO_COST;
import static lotto.view.OutputView.printPurchaseMessage;

import java.util.List;
import lotto.service.BuyerService;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;

    public LottoGameController() {
        this.buyerService = new BuyerService();
    }

    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final List<Integer> winningNumbers;
    }

    private int getLottoQuantity() {
        String input = InputView.inputPurchaseAmount();
        return buyerService.calculateLottoQuantity(input);
    }

    private static void getWinningNumbers() {
        String input = InputView.inputWinningNumbers();
    }
}
