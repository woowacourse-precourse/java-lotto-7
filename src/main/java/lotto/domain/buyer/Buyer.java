package lotto.domain.buyer;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.Lottos;

public class Buyer {
    private final PurchaseCount purchaseCount;
    private final Lottos purchasedLottos;

    private Buyer(final PurchaseCount purchaseCount) {
        this.purchaseCount = purchaseCount;
        this.purchasedLottos = purchaseLottos(purchaseCount.getPurchaseCount());
    }

    public static Buyer from(final int purchaseMoney) {
        PurchaseCount purchaseCount = PurchaseCount.from(purchaseMoney);
        return new Buyer(purchaseCount);
    }

    private Lottos purchaseLottos(final int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < purchaseCount; idx++) {
            lottos.add(LottoFactory.createRandomLotto());
        }

        return Lottos.of(lottos);
    }
}
