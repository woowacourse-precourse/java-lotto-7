package lotto.domain.buyer;

import static lotto.domain.buyer.LottosCount.from;

;

public class BuyerFactory {

    public static Buyer createBuyer(final int purchaseMoney) {
        final LottosCount LottosCount = from(purchaseMoney);

        final BuyLottos buyLottos = BuyLottos.generateRandomLottos(LottosCount);

        return new Buyer(LottosCount, buyLottos);
    }

    public static Buyer createTestBuyer(final int purchaseMoney, final BuyLottos customLottos) {
        final LottosCount LottosCount = from(purchaseMoney);

        return new Buyer(LottosCount, customLottos);
    }
}
