package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoBall implements Comparable<LottoBall> {

    private static final Map<Integer, LottoBall> LOTTO_BALLS = new HashMap<>();
    public static final int NUMBER_START_INCLUSIVE = 1;
    public static final int NUMBER_END_INCLUSIVE = 45;

    private final int number;

    static {
        IntStream.rangeClosed(NUMBER_START_INCLUSIVE, NUMBER_END_INCLUSIVE)
                .forEach(number -> LOTTO_BALLS.put(number, new LottoBall(number)));
    }

    private LottoBall(final int number) {
        this.number = number;
    }

    public static LottoBall draw(final int number) {
        validateLottoNumberRange(number);
        return LOTTO_BALLS.get(number);
    }

    private static void validateLottoNumberRange(final int number) {
        if (number < NUMBER_START_INCLUSIVE || number > NUMBER_END_INCLUSIVE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public int number() {
        return number;
    }

    @Override
    public int compareTo(final LottoBall o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoBall lottoBall)) {
            return false;
        }
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "LottoBall{" +
                "number=" + number +
                '}';
    }

}
