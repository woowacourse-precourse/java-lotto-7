package lotto.model.number_generator;

import java.util.List;

public interface RandomNumberGenerator {

    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
