package lotto.domain;

import java.util.List;
import lotto.domain.strategy.NumberGenerationStrategy;

public class LottoMachine {

    public Lotto issueLotto(NumberGenerationStrategy numberGenerationStrategy) {
        List<Integer> numbers = numberGenerationStrategy.generate(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER,
                Lotto.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
