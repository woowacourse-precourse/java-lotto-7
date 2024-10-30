package lotto.domain.number;

import java.util.List;

public interface NumbersGenerator<T extends Number> {

    List<T> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);

}
