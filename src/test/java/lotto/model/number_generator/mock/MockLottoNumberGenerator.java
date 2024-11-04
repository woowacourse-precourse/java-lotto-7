package lotto.model.number_generator.mock;

import lotto.model.number_generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockLottoNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public MockLottoNumberGenerator(int start, int end) {
        this.numbers = IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
