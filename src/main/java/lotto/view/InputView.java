package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    public static int buyLotto(){
        OutputView.printLottoAmountInput();
        String purchaseAmout = Console.readLine();
        return InputValidator.validatePurchaseAmout(purchaseAmout);
    }
}
