package lotto.validation;

import java.util.HashSet;
import java.util.List;

public class LottoNumberValidator {

    private static final int LOTTO_SIZE = 6;

    private LottoNumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateDuplication(List<Integer> numbers) {

        int deduplicatedNumbersCount = new HashSet<>(numbers).size();
        if (deduplicatedNumbersCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
