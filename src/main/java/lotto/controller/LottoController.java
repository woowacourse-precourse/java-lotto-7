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
        int purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }

    private int getPurchaseAmount() {
        int purchaseAmount = InputView.getPurchaseAmount();
        inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
        return purchaseAmount;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = Separator.splitWithCommaToInteger(InputView.getWinningNumbers());
        inputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int getBonusNumber() {
        int bonusNumber = toInt(InputView.getBonusNumber());
        inputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

}
