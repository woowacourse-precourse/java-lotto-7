package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private int matchWinningNumbers(List<Integer> numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonusNumber(Integer number) {
        return numbers.contains(number);
    }

}
