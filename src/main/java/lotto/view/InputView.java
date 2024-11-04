package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import lotto.domain.BonusNumberValidator;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumberValidator;
import lotto.message.ErrorMessage;
import lotto.validator.LottoAmountValidator;

public class InputView {
    public static int buyLotto() {
        OutputView.printLottoAmountInput();
        String purchaseAmout = Console.readLine();
        purchaseAmout = purchaseAmout.trim();
        return LottoAmountValidator.validatePurchaseAmout(purchaseAmout);
    }

    public static Set<Integer> inputWinningNumber() {
        OutputView.printWinningNumberInput();
        String winningNumber = Console.readLine();
        winningNumber = winningNumber.trim();
        if (winningNumber.startsWith(",") || winningNumber.endsWith(",") || winningNumber.contains(",,")) {
            System.out.println(ErrorMessage.INVALID_COMMA_FORMAT.getMessage());
            return inputWinningNumber();
        }
        String[] winningNumbers = winningNumber.split(",");
        return WinningNumberValidator.validateWinningNumber(winningNumbers);
    }

    public static int inputBonusNumber(){
        OutputView.printBonusNumberInput();
        String bonusNumber = Console.readLine();
        bonusNumber = bonusNumber.trim();
        return BonusNumberValidator.validateBonusNumber(bonusNumber, WinningNumber.getWinningNumbers());
    }
}
