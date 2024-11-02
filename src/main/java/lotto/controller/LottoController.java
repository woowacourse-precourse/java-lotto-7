package lotto.controller;

import lotto.Lotto;
import lotto.util.ErrorMessage;
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
        Lotto lotto = createLotto();
        int bonusNumber = getValidatedBonusNumber();
    }

    private int getPurchaseAmount() {
        int purchaseAmount = parseInt(InputView.getPurchaseAmount());
        inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
        return purchaseAmount;
    }

    private Lotto createLotto() {
        List<Integer> winningNumbers = Separator.splitWithCommaToInteger(InputView.getWinningNumbers());
        return new Lotto(winningNumbers);
    }

    private int getValidatedBonusNumber() {
        int bonusNumber = parseInt(InputView.getBonusNumber());
        inputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
        }
    }

}
