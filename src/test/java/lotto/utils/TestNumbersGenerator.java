package lotto.utils;

import java.util.List;

public class TestNumbersGenerator implements NumbersGenerator {
    private final List<Integer> numbers;

    public TestNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> createNumbers() {
        return numbers;
    }
}
