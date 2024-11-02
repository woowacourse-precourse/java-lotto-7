package lotto.number_generator;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> generate() {
        return List.of(6, 5, 4, 3, 2, 1);
    }
}
