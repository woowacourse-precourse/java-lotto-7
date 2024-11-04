package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import lotto.exception.argument.lotto.InvalidLottoNumberException;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> CACHE;

    static {
        CACHE = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .mapToObj(LottoNumber::new)
                .toList();
    }

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        validateNumber(number);
        return CACHE.get(number - 1);
    }

    private static void validateNumber(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException("로또 번호는 1 이상 45 이하여야 합니다.");
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
