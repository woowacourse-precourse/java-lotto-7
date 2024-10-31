package lotto.validation;

import lotto.util.Convertor;

public class BonusNumberValidator {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;

    public static void validateRange(String input) {
        int bonusNum = Convertor.convertToInt(input);
        if (bonusNum > MAX_NUMBER_RANGE || bonusNum < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자를 입력해야 합니다.");
        }
    }
}
