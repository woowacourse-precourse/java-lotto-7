package lotto.util;

import java.util.List;

public class FixedNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generateNumbers(int start, int end, int count) {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
