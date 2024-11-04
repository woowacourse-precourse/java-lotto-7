package lotto.validation;

import lotto.exception.ErrorMessage;

public class AmountValidator {

    public static void validateOnlyNumeric(String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_NOT_NUMERIC.toString()); // 예외 메시지 수정
        }
    }

    public static void validateAmount(int amount) {
        if (isThousand(amount)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND.toString());
        }
    }

    private static boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean isThousand(int amount) {
        return amount % 1000!=0;
    }
}
