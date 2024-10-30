package lotto.utils;

public class LottoNumberValidator {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;

    public static boolean isWithinRange(int number) {
        return number >= MIN_BOUND && number <= MAX_BOUND;
    }
}
