package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lottonumberstrategy.RandomNumbersStrategy;

public class LottoGenerator {

    private final RandomNumbersStrategy randomNumbersStrategy;

    public LottoGenerator(RandomNumbersStrategy randomNumbersStrategy) {
        this.randomNumbersStrategy = randomNumbersStrategy;
    }

    public List<Lotto> issues(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(issue());
        }
        return lottos;
    }

    private Lotto issue() {
        List<Integer> numbers = randomNumbersStrategy.generateNumbers();
        return Lotto.of(numbers);
    }
}
