package lotto.common.factory;

import lotto.common.random.NumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoFactory {
    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos sizeFrom(int size) {
        Lottos lottos = new Lottos();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.addLotto(new Lotto(numberGenerator.generate()));
        }
        return lottos;
    }
}
