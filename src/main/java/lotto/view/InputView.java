package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoAmountValidator;

public class InputView {
    public static int buyLotto() {
        OutputView.printLottoAmountInput();
        String purchaseAmout = Console.readLine();
        return LottoAmountValidator.validatePurchaseAmout(purchaseAmout);
    }
}
