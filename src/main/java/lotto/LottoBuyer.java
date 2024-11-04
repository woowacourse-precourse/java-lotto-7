package lotto;

import java.util.List;

public class LottoBuyer {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    LottoBuyer(List<Lotto> lottos, PurchaseAmount purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }
}
