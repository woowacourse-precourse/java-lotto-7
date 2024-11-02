package lotto;

import java.util.List;

public class LottoMachine {
    private static final long LOTTO_PRICE = 1000;

    public void run() {
        long purchaseCount = getPurchaseCountFromUser();
        List<Lotto> lottos = Lotto.generateLottos(purchaseCount);
    }

    private long getPurchaseCountFromUser() {
        long amount = InputView.getAmountFromUser();
        Validator.checkValidPurchaseCount(amount);
        return amount / LOTTO_PRICE;
    }
}
