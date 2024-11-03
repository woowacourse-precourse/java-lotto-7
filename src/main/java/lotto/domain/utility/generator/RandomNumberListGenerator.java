package lotto.domain.utility.generator;

import java.util.List;

public interface RandomNumberListGenerator<T extends Number> {

    List<T> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);

}
