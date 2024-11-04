package lotto.exceptions;

import static lotto.constants.ExceptionDisplayConstants.USER_INPUT_ERROR_PREFIX;

public class BonusNumberException extends IllegalArgumentException{
    private static final String MESSAGE = USER_INPUT_ERROR_PREFIX + "보너스 번호는 1-45사이의 숫자 입니다.";

    public BonusNumberException() {
        super(MESSAGE);
    }
}
