package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final int PRICE_OF_LOTTO = 1000;
    private List<Lotto> lottos;
    public void buyLotto(Store store, Money money) {
        lottos = store.sellLottos(money, getBuyableCount(money));
    }
    public int getBuyableCount(Money money) {
        int leftMoney = money.getLeftMoney();
        return leftMoney / PRICE_OF_LOTTO;
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
