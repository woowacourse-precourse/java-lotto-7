package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.NumberGenerationStrategy;

public class LottoSeller {

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos sellUntilNoMoney(Money money, NumberGenerationStrategy numberGenerationStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isGreaterEqualThan(LOTTO_PRICE)) {
            lottos.add(lottoMachine.issueLotto(numberGenerationStrategy));
            money = money.minus(LOTTO_PRICE);
        }

        return Lottos.from(lottos);
    }
}
