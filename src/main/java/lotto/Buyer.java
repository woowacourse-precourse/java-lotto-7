package lotto;

import java.util.List;

public class Buyer {
    private final Integer money;
    private final LottoStore lottoStore;
    private List<Lotto> purchasedLottos;

    public Buyer(Integer money, LottoStore lottoStore) {
        this.money = money;
        this.lottoStore = lottoStore;
    }

    public void buyLotto() {
        purchasedLottos = lottoStore.sellLotto(money);
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public Integer getMoney() {
        return this.money;
    }
}
