package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.io.InputValidation;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();

        InputValidation.validateNullOrEmpty(purchaseAmount);
        InputValidation.validateContainBlank(purchaseAmount);
        InputValidation.validateNumeric(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }
}
