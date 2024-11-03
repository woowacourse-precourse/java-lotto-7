package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final int purchaseAmount;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public Buyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void purchaseLottos(LottoNumGenerator lottoNumGenerator) {
        int numberOfTickets = purchaseAmount / 1000;
        for (int i = 0; i < numberOfTickets; i++) {
            purchasedLottos.add(new Lotto(lottoNumGenerator.generateNum()));
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
