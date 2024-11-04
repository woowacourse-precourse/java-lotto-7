package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final List<LottoNumber> NUMBER_POOL = new ArrayList<>();

    private final int number;

    static {
        IntStream.rangeClosed(0, MAX_LOTTO_NUMBER_RANGE.getValue())
                .mapToObj(LottoNumber::new)
                .forEach(NUMBER_POOL::add);
    }

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        LottoNumberValidator.validateLottoNumber(number);
        return NUMBER_POOL.get(number);
    }

    public int getNumber() {
        return number;
    }
}
