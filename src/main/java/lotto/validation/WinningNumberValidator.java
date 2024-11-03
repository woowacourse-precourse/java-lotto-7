package lotto.validation;

import lotto.enums.Message;
import lotto.util.Convertor;

public class WinningNumberValidator {

    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;

    private WinningNumberValidator() {}

    public static void validateRange(String input) {
        int winningNum = Convertor.convertToInt(input);
        if (winningNum > MAX_NUMBER_RANGE || winningNum < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "당첨 번호는 1~45 사이의 숫자를 입력해야 합니다.");
        }
    }

}
