package lotto.domain;

import lotto.domain.validator.RangeValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Money money;
    private final RangeValidator rangeValidator;

    public LottoMachine(Money money, RangeValidator rangeValidator) {
        this.money = money;
        this.rangeValidator = rangeValidator;
    }

    public Lottos create() {
        int lottoCount = money.availableLottoCount();
        List<Lotto> lottos = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), rangeValidator);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

}
