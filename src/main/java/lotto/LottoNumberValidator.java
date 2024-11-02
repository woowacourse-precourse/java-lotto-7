package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int LOTTO_NUMBERS_REQUIRED = 6;

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> checker = new HashSet<>();
        numbers
                .forEach(number -> {
                    if (!checker.add(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 번호가 있어요.");
                    }
                });
    }

    public static void validateRange(List<Integer> numbers) {
        numbers
                .forEach(number -> {
                    if (number < MINIMUM || number > MAXIMUM) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45까지의 숫자로만 이루어져야해요.");
                    }
                });
    }

    public static void validateNumbersRequired(List<Integer> numbers) {
        if (LOTTO_NUMBERS_REQUIRED != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersRequired(numbers);
        validateDuplicateNumber(numbers);
        validateRange(numbers);
    }
}
