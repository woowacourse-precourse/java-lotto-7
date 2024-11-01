package lotto.domain;

import java.util.List;
import lotto.domain.strategy.LottoNumberGenerationStrategy;

public class LottoMachine {

    public Lotto issueLotto(LottoNumberGenerationStrategy lottoNumberGenerationStrategy) {
        List<Integer> numbers = lottoNumberGenerationStrategy.generate(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER,
                Lotto.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
