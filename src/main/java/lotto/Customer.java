package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    public Customer(int money) {
        this.money = money;
    }

    public void purchaseLottoFrom(LottoStore lottoStore) {
        int availableBuyCount = lottoStore.calculateLottoCount(money);
        lottos.addAll(lottoStore.sell(availableBuyCount));
        money -= availableBuyCount * LottoStore.LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
