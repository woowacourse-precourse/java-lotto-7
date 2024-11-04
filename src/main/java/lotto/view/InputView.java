package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.WinningNumberValidator;
import lotto.message.ErrorMessage;
import lotto.validator.LottoAmountValidator;

public class InputView {
    public static int buyLotto() {
        OutputView.printLottoAmountInput();
        String purchaseAmout = Console.readLine();
        return LottoAmountValidator.validatePurchaseAmout(purchaseAmout);
    }

    public static List<Integer> inputWinningNumber() {
        OutputView.printWinningNumberInput();
        String winningNumber = Console.readLine();

        if (winningNumber.startsWith(",") || winningNumber.endsWith(",") || winningNumber.contains(",,")) {
            System.out.println(ErrorMessage.INVALID_COMMA_FORMAT.getMessage());
            return inputWinningNumber();
        }

        String[] winningNumbers = winningNumber.split(",");
        return WinningNumberValidator.validateWinningNumber(winningNumbers);
    }
}
