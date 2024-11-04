package lotto.domain.utility.converter;

import static lotto.common.exception.ErrorMessage.INPUT_MUST_BE_NUMERIC;

import lotto.common.exception.LottoException;

public class Converter {

    public int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(INPUT_MUST_BE_NUMERIC);
        }
    }
}
