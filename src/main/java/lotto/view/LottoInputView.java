package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.NumbersValidator;
import lotto.validator.PurchaseAmountValidator;

import static lotto.view.LottoOutputView.*;

public class LottoInputView {
    private final NumbersValidator numbersValidator = new NumbersValidator();

    private String getInput() {
        return Console.readLine();
    }

    public int getInputPurchaseAmount() {
        boolean isFirstPrompt = true;
        while (true) {
            promptPurchaseAmount(isFirstPrompt);
            isFirstPrompt = false;
            String purchaseAmountInput = getInput();
            try {
                return PurchaseAmountValidator.validateAndParse(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public List<Integer> getInputWinningNumbers() {
        while (true) {
            promptWinningNumbers();
            String winningNumbersInput = getInput();
            try {
                numbersValidator.validateWinningNumbers(winningNumbersInput);
                return numbersValidator.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public List<Integer> getInputBonusNumber() {
        while (true) {
            promptBonusNumber();
            String bonusNumberInput = getInput();
            try {
                numbersValidator.validateBonusNumber(bonusNumberInput);
                return numbersValidator.getBonusNumber();
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }
}
