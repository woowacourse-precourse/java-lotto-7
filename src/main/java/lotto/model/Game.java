package lotto.model;

import java.util.List;
import lotto.model.purchase.LottoStore;

public class Game {
    private final LottoStore lottoStore;
    private List<Lotto> purchasedLottos;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
        this.purchasedLottos = List.of();
    }

    public void purchaseLottos(int amount) {
        purchasedLottos = lottoStore.purchaseLottoTickets(amount);
    }

}
