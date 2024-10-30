package lotto.domain.factory;

import lotto.domain.RandomLottos;

public class RandomLottoFactory {
    private final RandomLottoMachine lottoMachine;

    public RandomLottoFactory(RandomLottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public RandomLottos make() {
        return new RandomLottos(lottoMachine.makeLottos());
    }

}
