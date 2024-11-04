package lotto.domain;

import java.util.List;

public class TestNumbersGenerator implements NumbersGenerator {
    private final List<Integer> numbers;

    public TestNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
