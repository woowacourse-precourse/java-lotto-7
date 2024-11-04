package lotto.domain;

import static lotto.util.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private List<Lotto> lottos;

    public PurchaseLottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> saveAll(List<Lotto> purchaseLottos) {
        lottos.addAll(purchaseLottos);
        return getLottos();
    }

    public Integer findLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos.stream().toList();
    }

    public int purchaseAmount() {
        return lottos.size() * LOTTO_PRICE;
    }
}
