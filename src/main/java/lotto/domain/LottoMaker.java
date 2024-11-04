package lotto.domain;

import static lotto.domain.LottoNumberGenerator.generateNumbers;

import java.util.List;
import java.util.stream.Stream;

public class LottoMaker {
    Budget budget;

    public LottoMaker(Budget budget) {
        this.budget = budget;
    }

    private Lotto makeLotto() {
        return new Lotto(generateNumbers());
    }

    public List<Lotto> getLottos() {
        int lottoCount = budget.getLottoCount();
        return Stream.generate(this::makeLotto)
                .limit(lottoCount)
                .toList();
    }
}