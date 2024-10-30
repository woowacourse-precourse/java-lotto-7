package lotto.controller;

import static lotto.constant.LottoGameRule.LOTTO_COST;
import static lotto.view.OutputView.printPurchaseMessage;

import java.util.List;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;

public class LottoGameController {
    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final List<Integer> winningNumbers;
    }

    private static int getPurchaseAmount() {
        String input = InputView.inputPurchaseAmount();
        return PurchaseAmountValidator.validate(input);
    }

    private static int getLottoQuantity() {
        int lottoQuantity =  getPurchaseAmount() / LOTTO_COST.getValue();
        printPurchaseMessage(lottoQuantity);

        return lottoQuantity;
    }

    private static void getWinningNumbers() {
        String input = InputView.inputWinningNumbers();
    }
}
