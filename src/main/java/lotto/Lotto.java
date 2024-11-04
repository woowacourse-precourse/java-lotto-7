package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (isInvalidRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1~45사이 여야 합니다.");
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복이 불가능합니다.");
        }
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < START_NUMBER || number > END_NUMBER);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
