package lotto.domain;

import java.util.List;

public class LottoSeller {
    
    public final static Money LOTTO_PRICE = Money.from(1000L);

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> buy(Money money) {
        Money divideMoney = money.divide(LOTTO_PRICE);
        validateLottoCount(divideMoney);

        return lottoMachine.issue(divideMoney.getAmount());
    }

    private void validateLottoCount(Money divideMoney) {
        if (divideMoney.isZero()) {
            throw new IllegalArgumentException("로또를 살 수 없습니다. 로또는 1000원입니다.");
        }
    }
}
