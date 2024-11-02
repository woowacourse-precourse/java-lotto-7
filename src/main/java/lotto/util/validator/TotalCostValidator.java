package lotto.util.validator;

import static lotto.util.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static lotto.util.message.ExceptionMessage.NOT_DIVIDED_TO_LOTTO_PRICE;

public class TotalCostValidator extends InputValidator {

    public static Long validateDividedByLottoPrice(String input) {
        Long totalCost = validateLongInt(input);
        if (totalCost % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_TO_LOTTO_PRICE.toString());
        }
        return totalCost;
    }
}
