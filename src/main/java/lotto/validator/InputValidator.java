package lotto.validator;

import lotto.utils.ExceptionUtils;

public class InputValidator {
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값에 공백을 허용하지 않습니다.";


    private InputValidator(){
    }

    public static void validatePurchaseAmount(String input){
        checkEmptyInput(input);
    }

    public static void validateWinNumbers(String input){
        checkEmptyInput(input);
    }

    public static void validateBonusNumber(String input){
        checkEmptyInput(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isBlank()) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

}
