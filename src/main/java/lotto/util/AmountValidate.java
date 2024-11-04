package lotto.util;

import lotto.exception.ErrorMessages;

public class AmountValidate {

    public static void validate(String input) {
        checkType(input);
        checkMinRange(input);
        checkThousandUnit(input);
    }

    // 입력값 자료형 검사
    private static void checkType(String input) {
        String regex = "^[1-9]\\d*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_INT.getMessage());
        }
    }

    // 입력값 최소값 검사
    private static void checkMinRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessages.MIN_RANGE.getMessage());
        }
    }

    // 입력값 유효성 검사
    private static void checkThousandUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.THOUSAND_UNIT.getMessage());
        }
    }

}
