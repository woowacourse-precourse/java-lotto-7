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
        String purchaseAmout = Console.readLine();
        purchaseAmout = purchaseAmout.trim();
        return LottoAmountValidator.validatePurchaseAmout(purchaseAmout);
    }

    public static Set<Integer> inputWinningNumber() {
        OutputView.printWinningNumberInput();
        String winningNumber = Console.readLine();
        winningNumber = winningNumber.trim();
        if (winningNumber.startsWith(",") || winningNumber.endsWith(",") || winningNumber.contains(",,")) {
            try{
                throw new IllegalArgumentException(ErrorMessage.INVALID_COMMA_FORMAT.getMessage());
            }catch(IllegalArgumentException e){
                OutputView.printErrorMessage(e.getMessage());
                return inputWinningNumber();
            }
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
