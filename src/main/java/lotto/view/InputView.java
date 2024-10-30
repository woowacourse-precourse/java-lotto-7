package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.io.InputValidation;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        InputValidation.validate(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }
}
