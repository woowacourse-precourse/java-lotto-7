package lotto.domain.buyer;

import lotto.domain.lotto.Lottos;

public class BuyerFactory {

    public static Buyer createBuyer(final int purchaseMoney) {
        final PurchaseCount purchaseCount = PurchaseCount.from(purchaseMoney);
        final Lottos purchasedLottos = Lottos.generateRandomLottos(purchaseCount);

        return new Buyer(purchaseCount, purchasedLottos);
    }

    public static Buyer createTestBuyer(final int purchaseMoney, final Lottos customLottos) {
        final PurchaseCount purchaseCount = PurchaseCount.from(purchaseMoney);

        return new Buyer(purchaseCount, customLottos);
    }
}
