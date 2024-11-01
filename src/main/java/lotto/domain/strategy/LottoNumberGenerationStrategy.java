package lotto.domain.strategy;

import java.util.List;

public interface LottoNumberGenerationStrategy {
    List<Integer> generate(int min, int max, int size);
}
