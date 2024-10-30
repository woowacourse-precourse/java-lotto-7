package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidLottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LENGTH = 6;

    public static boolean isNotBoundedNumbers(final List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER  && number <= MAX_NUMBER);
    }

    public static boolean isNotBoundedNumber(final int number) {
        return !(number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    public static boolean isNotSixNumbers(final List<Integer> numbers) {
        return numbers.size() != LENGTH;
    }

    public static boolean isDuplicate(final List<Integer> numbers) {
        final Set<Integer> setNumbers = new HashSet<>(numbers);
        return setNumbers.size() != numbers.size();
    }
}
