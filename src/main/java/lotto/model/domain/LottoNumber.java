package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBER_ERROR;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import java.util.Objects;
import lotto.util.InputParser;

public class LottoNumber {

    private final int number;

    public LottoNumber(String stringNumber) {
        int number = InputParser.parsePositiveNumber(stringNumber, INVALID_LOTTO_NUMBER_ERROR);
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR);
        }
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
