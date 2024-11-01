package lotto.domain;

import lotto.domain.provider.NumberProvider;
import lotto.domain.validator.RangeValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Money money;
    private final NumberProvider numberProvider;
    private final RangeValidator rangeValidator;

    public LottoMachine(Money money, NumberProvider numberProvider, RangeValidator rangeValidator) {
        this.money = money;
        this.numberProvider = numberProvider;
        this.rangeValidator = rangeValidator;
    }

    public Lottos create() {
        int lottoCount = money.availableLottoCount();
        List<Lotto> lottos = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberProvider, rangeValidator);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

}
