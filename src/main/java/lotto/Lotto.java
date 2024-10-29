package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_SIZE));
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d 사이여야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
