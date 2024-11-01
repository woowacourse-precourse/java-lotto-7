package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.LottoNumberGenerationStrategy;

public class LottoSeller {

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoGroups sellUntilNoMoney(Money money, LottoNumberGenerationStrategy lottoNumberGenerationStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isGreaterEqualThan(LOTTO_PRICE)) {
            lottos.add(lottoMachine.issueLotto(lottoNumberGenerationStrategy));
            money = money.minus(LOTTO_PRICE);
        }

        return LottoGroups.from(lottos);
    }
}
