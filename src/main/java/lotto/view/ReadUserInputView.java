package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.util.UserInputValidator;

public class ReadUserInputView {
    private UserInputValidator validator;

    public ReadUserInputView(UserInputValidator validator) {
        this.validator = validator;
    }

    public int readPurchaseAmount() {
        String purchaseAmount = readLine();
        validator.isValidPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }
}
