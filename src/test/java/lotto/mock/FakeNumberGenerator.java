package lotto.mock;

import java.util.List;
import lotto.global.util.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    private FakeNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static FakeNumberGenerator from(List<Integer> numbers) {
        return new FakeNumberGenerator(numbers);
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
