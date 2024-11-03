package lotto.validation;

import static lotto.constants.LottoRule.Thousand_Multi_Number;
import static lotto.constants.LottoRule.USE_ZERO;

public class BuyLottoValidate {

    public static int lottoBuyValidation(String inputAmount) {
        int count;
        int amount = amountValidation(inputAmount);
        checkNegativeNumber(amount);
        count = thousandMultiple(amount);
        return count;
    }

    public static int amountValidation(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNegativeNumber(int amount) {
        if (amount < USE_ZERO.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static int thousandMultiple(int amount) {
        if (amount % Thousand_Multi_Number.getValue() != USE_ZERO.getValue()
                || amount == USE_ZERO.getValue()) {
            throw new IllegalArgumentException();
        }
        return amount /= Thousand_Multi_Number.getValue();
    }
}
