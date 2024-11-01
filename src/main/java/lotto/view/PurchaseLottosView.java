package lotto.view;

import lotto.io.Output;
import lotto.model.Lottos;

public final class PurchaseLottosView {
    public static Lottos purchaseLottos(int purchaseQuantity) {
        Lottos lottos = new Lottos(purchaseQuantity);
        Output.printLottos(lottos);
        return lottos;
    }
}
