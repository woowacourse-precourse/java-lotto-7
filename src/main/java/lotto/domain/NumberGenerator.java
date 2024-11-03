package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public interface NumberGenerator<T extends Number> {

    List<T> generateNumbers();

    List<List<? extends Number>> generateNumbersBy(BigDecimal quantity);
}
