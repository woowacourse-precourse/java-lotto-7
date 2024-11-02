package lotto;

import java.util.List;

public class LottoGenerator {
    private final LottoStrategy lottoStrategy;

    public LottoGenerator(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumber());
    }

    public List<Integer> createLottoNumber() {
        return lottoStrategy.createNumber();
    }
}
