package lotto.purchase;

import lotto.Lottos;
import lotto.strategy.LottoNumberStrategy;

public class Purchase {

    private final PurchaseNumber purchaseNumber;
    private final Lottos lottos;

    public Purchase(PurchaseNumber purchaseNumber, Lottos lottos) {
        this.purchaseNumber = purchaseNumber;
        this.lottos = lottos;
    }

    public void purchaseLottos(LottoNumberStrategy strategy) {
       this.lottos.purchaseLottos(purchaseNumber.getNumber(), strategy);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public PurchaseNumber getPurchaseNumber() {
        return purchaseNumber;
    }

}
