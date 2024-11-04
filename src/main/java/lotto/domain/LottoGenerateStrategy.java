package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    List<Integer> pickNumbers();
}
