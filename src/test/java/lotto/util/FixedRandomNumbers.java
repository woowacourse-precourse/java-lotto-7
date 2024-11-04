package lotto.util;

import java.util.List;

public class FixedRandomNumbers implements GenerateNumbers {
    @Override
    public List<Integer> generateNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
