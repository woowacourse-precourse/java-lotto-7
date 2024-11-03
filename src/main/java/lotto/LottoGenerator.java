package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final LottoStrategy lottoStrategy;

    public LottoGenerator(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumber());
    }

    public List<Integer> createLottoNumber() {
        return lottoStrategy.createNumber().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
