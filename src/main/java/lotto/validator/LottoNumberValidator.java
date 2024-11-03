package lotto.validator;

import java.util.Collections;
import java.util.List;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateNumberCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .anyMatch(number -> Collections.frequency(numbers, number) > 1);

        if (hasDuplicates) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 존재합니다.");
        }
    }
}
