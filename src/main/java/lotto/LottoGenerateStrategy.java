package lotto;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    List<Integer> pickNumbers();
}
