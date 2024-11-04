package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lottonumberstrategy.NumberGeneratorStrategy;

public class LottoGenerator {

    private final NumberGeneratorStrategy numberGeneratorStrategy;

    public LottoGenerator(NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
    }

    public Lottos issues(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = issue();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private Lotto issue() {
        List<Integer> numbers = numberGeneratorStrategy.generateNumbers();
        return Lotto.from(numbers);
    }
}
