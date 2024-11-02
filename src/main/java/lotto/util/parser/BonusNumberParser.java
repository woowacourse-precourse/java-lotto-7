package lotto.util.parser;

import static lotto.message.ErrorMessage.NOT_NUMERIC_BONUS_NUMBER_ERROR_MESSAGE;

public class BonusNumberParser {

    public static int parseRawBonusNumber(String rawBonusNumber) {

        validateRawBonusNumber(rawBonusNumber);
        int bonusNumber = 0;

        try {
            bonusNumber = Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_BONUS_NUMBER_ERROR_MESSAGE.getContent());
        }

        return bonusNumber;
    }

    private static void validateRawBonusNumber(String rawBonusNumber) {
        if (rawBonusNumber.isBlank()) {
            throw new IllegalArgumentException("보너스 번호 입력시 빈 문자열을 입력할 수 없습니다.");
        }
    }
}
