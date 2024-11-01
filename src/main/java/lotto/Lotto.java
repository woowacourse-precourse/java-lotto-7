package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public Long countMatches(List<Integer> numbers) {
        if (this.numbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 로또 번호의 개수와 다릅니다.");
        }
        return this.numbers.stream().filter(numbers::contains).count();
    }
}
