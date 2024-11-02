package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public List<Lotto> buyLotto(int price, LottoGenerator generator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < calculateNumberOfPurchase(price); i++) {
            lottos.add(generator.makeLotto());
        }
        return lottos;
    }

    private int calculateNumberOfPurchase(int price) {
        return price / 1000;
    }
}
