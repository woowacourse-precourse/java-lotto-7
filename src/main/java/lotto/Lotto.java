package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

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
    }

    public Long countMatches(List<Integer> numbers) {
        return IntStream.range(0, COUNT).filter(i -> Objects.equals(this.numbers.get(i), numbers.get(i))).count();
    }
}
