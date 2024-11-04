package lotto.application.ticket.domain.payment;

import static lotto.application.ticket.constants.Constants.MAXIMUM_QUANTITY;
import static lotto.application.ticket.constants.Constants.MINIMUM_QUANTITY;
import static lotto.application.ticket.message.Message.MAXIMUM_QUANTITY_ERROR;
import static lotto.application.ticket.message.Message.MINIMUM_QUANTITY_ERROR;

public class LottoQuantity {


    private final int value;

    public LottoQuantity(int value) {
        this.value = value;
    }

    public static LottoQuantity of(int count) {
        validateInValidRange(count);

        return new LottoQuantity(count);
    }

    private static void validateInValidRange(int count) {
        validateMaximumQuantity(count);
        validateMinimumQuantity(count);
    }

    private static void validateMinimumQuantity(int count) {
        if (count < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException(MINIMUM_QUANTITY_ERROR);
        }
    }

    private static void validateMaximumQuantity(int count) {
        if (count > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException(MAXIMUM_QUANTITY_ERROR);
        }
    }

    public int getValue() {
        return value;
    }

}
