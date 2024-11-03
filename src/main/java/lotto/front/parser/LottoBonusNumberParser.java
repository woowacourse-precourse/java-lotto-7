package lotto.front.parser;

import lotto.global.exception.InvalidBonusNumberException;

public class LottoBonusNumberParser {

    public static Integer parse(String bonusNumber) {
        try {
            return Integer.valueOf(bonusNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidBonusNumberException();
        }
    }
}
