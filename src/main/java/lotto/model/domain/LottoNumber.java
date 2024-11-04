package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBER_ERROR;

import java.util.Objects;
import lotto.util.InputParser;
import lotto.util.LottoNumberValidator;

public class LottoNumber {

    private final int number;

    public LottoNumber(String stringNumber) {
        int number = InputParser.parsePositiveNumber(stringNumber, INVALID_LOTTO_NUMBER_ERROR);
        LottoNumberValidator.validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
