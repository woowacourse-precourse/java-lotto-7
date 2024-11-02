package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

    public long readPurchaseAmount() {
        String input = readInput();
        PurchaseAmountValidator.validate(input);
        return Long.parseLong(input);
    }

    private String readInput() {
        return Console.readLine();
    }
}
