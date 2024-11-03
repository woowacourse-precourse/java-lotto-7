package lotto;

import java.util.List;

public class LottoService {

    private final Cashier cashier;

    public LottoService(Cashier cashier) {
        this.cashier = cashier;
    }

    public List<Lotto> buyLotto(Money money) {
        return cashier.sellLotto(money);
    }
}
