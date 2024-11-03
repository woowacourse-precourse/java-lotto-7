package lotto.util;

import lotto.util.message.Messages;

import static lotto.util.message.Messages.*;

public class InputValidator {
    private final static int TICKET_PRICE = 1000;

    public int validatePrice(String str) {
        checkBlank(str);
        int price = convertStrToInt(str);

        checkCanDivide(price);
        return price;
    }

    private void checkCanDivide(int price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    private void checkBlank(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public int convertStrToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
