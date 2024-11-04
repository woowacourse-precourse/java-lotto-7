package lotto.model;

import java.util.Objects;
import lotto.exceptions.ArgumentException;

public final class LottoNumber implements Comparable<LottoNumber> {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;
    static final LottoNumber[] CACHE = new LottoNumber[MAX_VALUE + MIN_VALUE];

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) throws ArgumentException {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw ArgumentException.INVALID_LOTTO_NUMBER_RANGE;
        }

        if (CACHE[number] == null) {
            CACHE[number] = new LottoNumber(number);
            return CACHE[number];
        }

        return CACHE[number];
    }

    public static String toString(LottoNumber n) {
        return Integer.toString(n.number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

}

