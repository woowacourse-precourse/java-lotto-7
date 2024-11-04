package lotto.domain.util.parser;

import lotto.domain.exception.BonusNumberFormatException;
import lotto.domain.util.LottoNumberGenerator;

public class BonusNumberParser implements StringParser<Integer> {

    private static BonusNumberParser instance;

    private BonusNumberParser() {
    }

    public static BonusNumberParser getInstance() {
        if (instance == null) {
            instance = new BonusNumberParser();
        }
        return instance;
    }

    @Override
    public Integer parse(String input) {
        String trimmedInput = input.trim();

        validateNumeric(trimmedInput);
        int number = parseInt(trimmedInput);

        validateRange(number);

        return number;
    }

    public int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (isNotNumeric(input)) {
            throw BonusNumberFormatException.invalidNumber();
        }
    }

    private void validateRange(int value) {
        if (value <= LottoNumberGenerator.MIN_LOTTO_NUMBER || value > LottoNumberGenerator.MAX_LOTTO_NUMBER) {
            throw BonusNumberFormatException.outOfRange();
        }
    }
}
