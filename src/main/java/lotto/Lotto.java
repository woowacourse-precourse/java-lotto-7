package lotto;

import java.util.List;

public class Lotto implements Item {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6
                || numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int match(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return "[" +
                String.join(", ",
                        numbers.stream().map(String::valueOf).toList()) +
                ']';
    }

    // TODO: 추가 기능 구현
}
