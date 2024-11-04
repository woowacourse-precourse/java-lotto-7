package lotto.domain;

import java.util.List;
import lotto.vo.PurchaseAmount;

public class LottoBuyer {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    public LottoBuyer(List<Lotto> lottos, PurchaseAmount purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoCount() {
        return purchaseAmount.value() / LottoPublisher.LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.value();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
