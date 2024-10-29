package lotto;

import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
        });
    }
}
