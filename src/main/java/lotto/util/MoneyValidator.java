package lotto.util;

import lotto.enums.ErrorMessage;

public final class MoneyValidator {
    private static final String NUMBER_PATTERN = "^[0-9]+$";

    public static void validate(String input){
        if(input == null || input.isEmpty() || !input.matches(NUMBER_PATTERN))
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORM.format());

        int money = Integer.parseInt(input);
        if(money < 1000 || money % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.format());
    }
}
