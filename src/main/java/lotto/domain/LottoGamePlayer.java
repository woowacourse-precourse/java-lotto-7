package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGamePlayer {
    private List<Lotto> purchasedLottos;

    public LottoGamePlayer() {
        this.purchasedLottos = new ArrayList<>();
    }

    public void purchaseLottos(List<Lotto> lottos) {
        purchasedLottos = lottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
