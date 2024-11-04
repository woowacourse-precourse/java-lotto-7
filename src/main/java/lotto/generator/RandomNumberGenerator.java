package lotto.generator;

import java.util.List;

public interface RandomNumberGenerator {

    List<Integer> generate(int startInclusive, int endInclusive, int count);
}
