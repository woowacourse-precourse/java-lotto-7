package lotto.validator;

import java.util.List;

public class Validator {

    private static final String NUMERIC_REGEX = "-?\\d+";

    public static boolean isNumeric(String str) {
        return str.matches(NUMERIC_REGEX);
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isDivided(int num, int divider) {
        return num % divider == 0;
    }

    public static boolean isBetween(int minInclusive, int num, int maxInclusive) {
        return (minInclusive <= num) && (num <= maxInclusive);
    }

    /**
     * 리스트에 중복된 숫자가 있는지 확인
     *
     * @return 중복된 숫자가 있다면 true, 아니면 false
     */
    public static boolean hasDuplicateNumber(List<Integer> numbers) {
        int originSize = numbers.size();

        int uniqueSize = (int) numbers.stream()
                .distinct()
                .count();

        return originSize != uniqueSize;
    }
}
