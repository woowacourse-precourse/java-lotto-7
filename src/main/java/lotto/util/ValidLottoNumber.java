package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidLottoNumber {

    public static boolean isNotBoundedNumbers(final List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
    }

    public static boolean isNotBoundedNumber(final int number) {
        return !(number >= 1 && number <= 45);
    }

    public static boolean isNotSixNumbers(final List<Integer> numbers) {
        return numbers.size() != 6;
    }

    public static boolean isDuplicate(final List<Integer> numbers) {
        final Set<Integer> setNumbers = new HashSet<>(numbers);
        return setNumbers.size() != numbers.size();
    }
}
