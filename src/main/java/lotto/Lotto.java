package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String INVALID_LOTTO_COUNT_MESSAGE = "로또 번호는 6개여야 하며, 중복이 없어야 합니다.";
    private static final String INVALID_LOTTO_RANGE_MESSAGE = "로또 번호는 1에서 45사이어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT_MESSAGE);
        }

        boolean isWrongRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isWrongRange) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE_MESSAGE);
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchingNumbersBy(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::hasNumber)
                .count();
    }
}
