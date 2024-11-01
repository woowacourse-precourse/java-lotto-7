package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator<T extends Number> {

    List<T> generateNumbers();
}
