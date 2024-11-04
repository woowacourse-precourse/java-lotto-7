package lotto.util.generator;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
