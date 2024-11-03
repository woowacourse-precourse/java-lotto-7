package lotto.util;

import static lotto.exception.UserInputException.validatePurchaseAmount;
import static lotto.exception.UserInputException.validatePurchaseAmountValue;

public class UserUtil {

    public static int parseAndValidatePurchaseAmount(String input) {
        validatePurchaseAmount(input);
        int amount = convertStringToInt(input);
        validatePurchaseAmountValue(amount);
        return amount;
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
