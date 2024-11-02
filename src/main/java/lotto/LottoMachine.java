package lotto;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseCount = getPurchaseCountFromUser();
        List<Lotto> lottos = Lotto.generateLottos(purchaseCount);
        OutputView.printLottos(lottos);
    }

    private int getPurchaseCountFromUser() {
        int amount = InputView.getAmountFromUser();
        Validator.checkValidPurchaseCount(amount);
        return amount / LOTTO_PRICE;
    }
}
