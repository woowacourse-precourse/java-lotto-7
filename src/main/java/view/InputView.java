package view;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class InputView {
    public static long inputPurchaseMoney() {
        return inputPositiveNumber();
    }

    public static long inputPositiveNumber() {
        OutputView.printInputMoneyMessage();
        String inputContent = Console.readLine();
        Validator.validateLong(inputContent);
        Validator.validatePositiveNumber(inputContent);
        return Long.parseLong(inputContent);
    }
}
