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
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        if (isOutOfBounds(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isOutOfBounds(List<Integer> numbers) {
        return !numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().toList();
    }

    public int getMatchingNumberCount(List<Integer> winningNumbers) {
        return (int) this.numbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(w -> w == number))
                .count();
    }

    public boolean isBonusNumberMatched(int bonus) {
        return this.numbers.stream().anyMatch(number -> number == bonus);
    }
}

