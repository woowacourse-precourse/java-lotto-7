package lotto.domain.buyer;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.Lottos;

public class BuyerFactory {

    public static Buyer createBuyer(final int purchaseMoney) {
        final PurchaseCount purchaseCount = PurchaseCount.from(purchaseMoney);
        final Lottos purchasedLottos = purchaseLottos(purchaseCount);

        return new Buyer(purchaseCount, purchasedLottos);
    }

    public static Buyer createTestBuyer(final int purchaseMoney, final Lottos customLottos) {
        final PurchaseCount purchaseCount = PurchaseCount.from(purchaseMoney);

        return new Buyer(purchaseCount, customLottos);
    }

    private static Lottos purchaseLottos(final PurchaseCount purchaseCount) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < purchaseCount.getPurchaseCount(); idx++) {
            lottos.add(LottoFactory.createRandomLotto());
        }

        return Lottos.of(lottos);
    }
}
