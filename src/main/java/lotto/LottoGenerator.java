package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final GenerateStrategy generateStrategy;

    public LottoGenerator(GenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumber());
    }

    public List<Integer> createLottoNumber() {
        return generateStrategy.generateNumber().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
