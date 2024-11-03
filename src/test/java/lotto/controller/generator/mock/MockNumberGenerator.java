package lotto.controller.generator.mock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.controller.generator.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate(final int count) {
        return IntStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toList());
    }
}
