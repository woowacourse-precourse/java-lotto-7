package lotto.domain;

import java.util.regex.Pattern;
import lotto.exception.InputErrorCode;
import lotto.exception.LottoException;

public class BonusNumber {
    private static final Pattern VALID_BONUS_LOTTO_NUMBER_RANGE_PATTERN = Pattern.compile(
            "^([1-9]|[1-3][0-9]|4[0-5])$");

    private final Integer number;

    public BonusNumber(String stringNumber) {
        validate(stringNumber);
        this.number = Integer.parseInt(stringNumber);
    }

    private void validate(String stringNumber) {
        if (!VALID_BONUS_LOTTO_NUMBER_RANGE_PATTERN.matcher(stringNumber).matches()) {
            throw new LottoException(InputErrorCode.BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
