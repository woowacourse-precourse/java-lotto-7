package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        numbers.forEach((number) -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                String errorMessage = String.format("[ERROR] 로또 번호는 %d 이상, %d 이하 정수여야 합니다.", MIN_NUMBER, MAX_NUMBER);
                throw new IllegalArgumentException(errorMessage);
            }
        });
    }

    public List<Integer> getImmutableNumbers() {
        return List.copyOf(numbers);
    }
}
