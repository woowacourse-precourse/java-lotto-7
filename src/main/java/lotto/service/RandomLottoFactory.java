package lotto.service;

import java.util.List;
import lotto.domain.factory.RandomLottoMachine;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;

public class RandomLottoFactory {
    private final RandomLottoMachine lottoMachine;

    public RandomLottoFactory(RandomLottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public RandomLottos make() {
        List<Lotto> lottos = lottoMachine.makeLottos();
        return new RandomLottos(lottos);
    }

}
