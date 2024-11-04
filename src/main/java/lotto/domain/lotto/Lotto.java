package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_MESSAGE_COUNT = "[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATION = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_COUNT);
        }
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATION);
        }
    }
}
