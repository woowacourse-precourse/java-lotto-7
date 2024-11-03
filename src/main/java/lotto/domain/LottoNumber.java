package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {

    public final static int LOTTO_NUM_MIN_VALUE = 1;
    public final static int LOTTO_NUM_MAX_VALUE = 45;
    private static final List<LottoNumber> cache;

    private final int number;

    static {
        cache = IntStream.rangeClosed(LOTTO_NUM_MIN_VALUE, LOTTO_NUM_MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .toList();
    }

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        validate(number);
        return cache.get(number - 1);
    }

    private static void validate(final int number) {
        if (number < LOTTO_NUM_MIN_VALUE || number > LOTTO_NUM_MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
        }
    }

    public String toString() {
        return String.valueOf(number);
    }

    public Integer toInteger() {
        return number;
    }

}
