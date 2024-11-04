package lotto.view;

import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.model.Lottos;

public final class PurchaseLottosView {
    public static Lottos purchaseLottos(int purchaseQuantity) {
        Output.printlnFormattedMessage(IOMessage.OUTPUT_PURCHASE_QUANTITY.getMessage(), purchaseQuantity);
        Lottos lottos = new Lottos(purchaseQuantity);
        Output.printLottos(lottos);
        return lottos;
    }
}
