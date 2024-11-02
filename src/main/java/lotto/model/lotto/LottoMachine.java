package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lottogenerator.LottoGenerator;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;

    public LottoMachine(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos execute(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return new Lottos(lottos);
    }

    private Lotto generate() {
        final List<Integer> lotto = lottoGenerator.generate();
        return new Lotto(lotto);
    }
}
