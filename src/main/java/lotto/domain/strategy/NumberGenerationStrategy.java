package lotto.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface NumberGenerationStrategy {
    List<Integer> generate(int min, int max, int size);
}
