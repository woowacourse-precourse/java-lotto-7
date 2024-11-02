package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
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
