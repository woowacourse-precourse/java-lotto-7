package lotto.controller;

import lotto.util.InputValidator;
import lotto.util.Separator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private final InputValidator inputValidator;

    public LottoController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
        List<Integer> winningNumbers = Separator.splitWithCommaToInteger(InputView.getWinningNumbers());
        inputValidator.validateWinningNumbers(winningNumbers);
    }

}
