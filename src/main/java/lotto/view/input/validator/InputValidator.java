package lotto.view.input.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {
    public static void moneyValidate(String input) {
        if (RegexPattern.NUMBER_REGEX.unMatch(input)) ErrorMessage.NUMBER_REGEX_PATTERN.throwIllegalArgumentException();
    }
    public static void bonusNumberValidate(String input) {
        if (RegexPattern.NUMBER_REGEX.unMatch(input)) ErrorMessage.NUMBER_REGEX_PATTERN.throwIllegalArgumentException();
    }
    public static void winningLottoValidate(String input) {
        if (RegexPattern.LOTTO_REGEX.unMatch(input)) ErrorMessage.LOTTO_REGEX_PATTERN.throwIllegalArgumentException();
    }
}
