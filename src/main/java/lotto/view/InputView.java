package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import lotto.validator.BonusNumberValidator;
import lotto.domain.WinningNumber;
import lotto.validator.WinningNumberValidator;
import lotto.message.ErrorMessage;
import lotto.validator.LottoAmountValidator;

public class InputView {
    public static int buyLotto() {
        OutputView.printLottoAmountInput();
        while (true) {
            try {
                String purchaseAmount = Console.readLine().trim();
                return LottoAmountValidator.validatePurchaseAmout(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static Set<Integer> inputWinningNumber() {
        OutputView.printWinningNumberInput();
        while (true) {
            try {
                String winningNumber = Console.readLine().trim();
                if (winningNumber.startsWith(",") || winningNumber.endsWith(",") || winningNumber.contains(",,")) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_COMMA_FORMAT.getMessage());
                }
                String[] winningNumbers = winningNumber.split(",");
                return WinningNumberValidator.validateWinningNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        OutputView.printBonusNumberInput();
        while (true) {
            try {
                String bonusNumber = Console.readLine().trim();
                return BonusNumberValidator.validateBonusNumber(bonusNumber, WinningNumber.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
