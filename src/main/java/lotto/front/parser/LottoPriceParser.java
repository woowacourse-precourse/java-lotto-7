package lotto.front.parser;

import lotto.global.exception.InvalidLottoPriceException;

public class LottoPriceParser {

    public static Integer parse(String lottoPrice) {
        try {
            return Integer.valueOf(lottoPrice);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidLottoPriceException();
        }
    }
}
