package lotto.support.generator;

import java.math.BigDecimal;
import java.util.List;

public interface NumberGenerator<T extends Number> {

    List<List<? extends Number>> generateNumbersBy(BigDecimal quantity);
}
