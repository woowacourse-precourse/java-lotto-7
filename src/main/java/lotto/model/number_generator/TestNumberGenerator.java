package lotto.model.number_generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestNumberGenerator implements NumberGenerator{

    private final List<Integer> numbers;

    public TestNumberGenerator(int start, int end) {
        this.numbers = IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
