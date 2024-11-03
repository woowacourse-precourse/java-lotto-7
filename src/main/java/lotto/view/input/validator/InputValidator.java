package lotto.view.input.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {
    public static void moneyValidate(String input) {
        if (!RegexPattern.NUMBER_REGEX.match(input)) ErrorMessage.NUMBER_REGEX_PATTERN.throwIllegalArgumentException();
    }
    public static void bonusNumberValidate(String input) {
        if (!RegexPattern.NUMBER_REGEX.match(input)) ErrorMessage.NUMBER_REGEX_PATTERN.throwIllegalArgumentException();
    }
    public static void winningLottoValidate(String input) {
        if (!RegexPattern.LOTTO_REGEX.match(input)) ErrorMessage.LOTTO_REGEX_PATTERN.throwIllegalArgumentException();
    }
}
