package lotto.validator;

import lotto.common.error.InputErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    // 입력 값 검증
    public static int validateInteger(String input) {
        validateNotNull(input);
        validateNotEmpty(input);
        return validateNumeric(input);
    }

    public static List<Integer> validateWinningNumbers(String input) {
        validateNotNull(input);
        validateNotEmpty(input);
        return validateNumericList(input);
    }


    // 검증 메서드들
    private static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(InputErrorMessage.NULL_INPUT.getInfoMessage());
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.NULL_INPUT.getInfoMessage());
        }
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_INPUT_TYPE.getInfoMessage());
        }
    }

    private static List<Integer> validateNumericList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(InputValidator::validateNumeric).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_INPUT_TYPE.getInfoMessage());
        }
    }
}