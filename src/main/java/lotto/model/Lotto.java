package lotto.model;

import java.util.List;

public class Lotto {

    public static final int SIZE = 6;
    public static final int MINIMUM_THRESHOLD = 1;
    public static final int MAXIMUM_THRESHOLD = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_THRESHOLD || number > MAXIMUM_THRESHOLD) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + MINIMUM_THRESHOLD + "이상, " + MAXIMUM_THRESHOLD + "이하만 가능합니다.");
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        final long notDuplicatedCount = numbers.stream()
                .distinct()
                .count();
        if (notDuplicatedCount != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되어선 안됩니다.");
        }
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
