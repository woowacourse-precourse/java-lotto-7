package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.NOT_DIVIDED_TO_LOTTO_PRICE;

public class TotalCostValidator extends InputValidator {

    public static Integer validateDividedByLottoPrice(String input) {
        int totalCost = validateInteger(input);
        if (totalCost % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_TO_LOTTO_PRICE.toString());
        }
        return totalCost;
    }
}
