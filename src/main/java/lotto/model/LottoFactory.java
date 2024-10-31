package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.model.random.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

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
