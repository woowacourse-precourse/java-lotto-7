package lotto.domain;

import lotto.domain.provider.NumberProvider;
import lotto.domain.validator.RangeValidator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final Money LOTTO_PRICE = new Money(BigInteger.valueOf(1000));

    private final NumberProvider numberProvider;
    private final RangeValidator rangeValidator;

    public LottoMachine(NumberProvider numberProvider, RangeValidator rangeValidator) {
        this.numberProvider = numberProvider;
        this.rangeValidator = rangeValidator;
    }

    public Lottos purchase(Money money) {
        validate(money);
        int lottoCount = money.divide(LOTTO_PRICE).intValue();

        List<Lotto> lottos = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberProvider, rangeValidator);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private void validate(Money money) {
        if (money.equals(new Money(BigInteger.ZERO))) {
            throw new IllegalArgumentException("로또 구입 금액은 0일 수 없습니다.");
        }

        BigInteger remainder = money.remainder(LOTTO_PRICE);
        if (!remainder.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

}
