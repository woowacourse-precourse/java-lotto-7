package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lottogenerator.LottoGenerateStrategy;

public class LottoMachine {
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoMachine(final LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public Lottos execute(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return new Lottos(lottos);
    }

    private Lotto generate() {
        final List<Integer> lotto = lottoGenerateStrategy.generate();
        return new Lotto(lotto);
    }
}
