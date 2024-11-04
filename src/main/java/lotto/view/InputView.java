package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import lotto.validator.BonusNumberValidator;
import lotto.domain.WinningNumber;
import lotto.validator.WinningNumberValidator;
import lotto.message.ErrorMessage;
import lotto.validator.LottoAmountValidator;

public class InputView {
    public static int inputLottoAmount() {
        OutputView.printLottoAmountInput();
        return getValidatedLottoAmount();
    }

    private static int getValidatedLottoAmount() {
        while (true) {
            try {
                String purchaseAmount = Console.readLine().trim();
                return LottoAmountValidator.validatePurchaseAmout(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
                OutputView.printLottoAmountInput();
            }
        }
    }

    public static Set<Integer> inputWinningNumber() {
        OutputView.printWinningNumberInput();
        return getValidatedWinningNumbers();
    }

    private static Set<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String winningNumber = Console.readLine().trim();
                validateCommaFormat(winningNumber);
                String[] winningNumbers = winningNumber.split(",");
                return WinningNumberValidator.validateWinningNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
                OutputView.printWinningNumberInput();
            }
        }
    }

    private static void validateCommaFormat(String winningNumber) {
        if (winningNumber.startsWith(",") || winningNumber.endsWith(",") || winningNumber.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMA_FORMAT.getMessage());
        }
    }

    public static int inputBonusNumber() {
        OutputView.printBonusNumberInput();
        return getValidatedBonusNumber();
    }

    private static int getValidatedBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine().trim();
                return BonusNumberValidator.validateBonusNumber(bonusNumber, WinningNumber.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
                OutputView.printBonusNumberInput();
            }
        }
    }
}
