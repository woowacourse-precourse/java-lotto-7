package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void sellUntilNoMoneyTo(Customer customer) {
        while (customer.hasMoney(LOTTO_PRICE)) {
            customer.buy(lottoMachine.issueLotto());
        }
    }

    public LottoGroups sellUntilNoMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isGreaterEqualThan(LOTTO_PRICE)) {
            lottos.add(lottoMachine.issueLotto());
            money = money.minus(LOTTO_PRICE);
        }

        return LottoGroups.from(lottos);
    }
}
