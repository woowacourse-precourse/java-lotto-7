package lotto.dto.request;

import static lotto.constant.ExceptionMessage.NOT_NUMBER_MONEY;

public record MoneyRequest(long money) {

    public static MoneyRequest from(String input) {
        try {
            return new MoneyRequest(Long.parseLong(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MONEY.getMessage());
        }
    }
}
