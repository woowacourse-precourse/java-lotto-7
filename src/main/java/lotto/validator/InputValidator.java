package lotto.validator;

import lotto.utils.ExceptionUtils;

public class InputValidator {
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값에 공백을 허용하지 않습니다.";
    private static final String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "양의 정수가 아닌 값은 허용하지 않습니다.";

    private InputValidator(){
    }

    public static void validatePurchaseAmount(String input){
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    public static void validateWinNumbers(String input){
        checkEmptyInput(input);
    }

    public static void validateBonusNumber(String input){
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isBlank()) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private static void checkPositiveNumber(String input){
        if (!input.matches("\\d+") || Integer.parseInt(input) <= 0) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_NOT_POSITIVE_NUMBER);
        }
    }

}
