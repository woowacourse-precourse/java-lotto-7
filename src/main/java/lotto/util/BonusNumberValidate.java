package lotto.util;

import lotto.exception.ErrorMessages;

import java.util.List;

public class BonusNumberValidate {

    public static void validate(String input, List<Integer> winningNumber) {
        checkType(input);
        checkRange(input);
        checkDuplicate(input, winningNumber);
    }

    // 입력값 자료형 검사
    private static void checkType(String input) {
        String regex = "^[1-9]\\d*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_INT.getMessage());
        }
    }

    // 입력값 범위 검사
    private static void checkRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }
    }

    // 입력값 중복 검사
    private static void checkDuplicate(String input, List<Integer> winningNumber) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_DUPLICATE_WITH_WINNING_NUMBER.getMessage());
        }
    }

}
