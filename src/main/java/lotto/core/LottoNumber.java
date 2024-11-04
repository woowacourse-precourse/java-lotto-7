package lotto.core;

import constants.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        IntStream.range(LOWER_BOUND, UPPER_BOUND + 1)
                .forEach(number -> LOTTO_NUMBERS.add(new LottoNumber(number)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validateRange(number);
        return LOTTO_NUMBERS.stream()
                .filter(lottoNumber -> Objects.equals(lottoNumber, LOTTO_NUMBERS.get(number - 1)))
                .findFirst()
                .orElseThrow();
    }

    private static void validateRange(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    public static LottoNumber toLottoNumber(String textNumber) {
        try {
            return LottoNumber.from(Integer.parseInt(textNumber));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.ENTERED_INVALID_NUMBER);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return number - lottoNumber.number;
    }
}
