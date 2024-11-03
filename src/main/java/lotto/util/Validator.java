package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;


public class Validator {

    // 정수 예외
    public static int validateNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 범위 예외
    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    // 중복값 예외
    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> testNumbers = new HashSet<>(numbers);
        if (testNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    //돈 단위 예외
    public static void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
