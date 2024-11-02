package lotto.domain;

import java.util.Objects;
import lotto.exception.InvalidLottoNumberException;
import lotto.support.IntegerConverter;

public class LottoNumber {

    private final int number;

    public LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber from(final String input, final IntegerConverter converter) {
        return new LottoNumber(converter.convertFrom(validateInput(input)));
    }

    private static String validateInput(final String input) {
        if (input == null) {
            throw new InvalidLottoNumberException("로또 번호는 null일 수 없습니다");
        }
        if (input.isBlank()) {
            throw new InvalidLottoNumberException("로또 번호는 비어있거나 공백일 수 없습니다");
        }
        return input;
    }

    private void validateNumber(final int number) {
        if (number < 1 || number > 45) {
            throw new InvalidLottoNumberException("로또 번호는 1 이상 45 이하여야 합니다");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
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
