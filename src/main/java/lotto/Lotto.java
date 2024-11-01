package lotto;

import java.util.ArrayList;
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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 없어야 합니다.");
        }
        if (!numbers.stream().allMatch(n -> 1 <= n && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지여야 합니다.");
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
