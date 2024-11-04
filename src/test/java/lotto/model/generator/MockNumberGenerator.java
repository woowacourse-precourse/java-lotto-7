package lotto.model.generator;

import java.util.List;

public class MockNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(5, 4, 2, 1, 3, 6);
    }
}