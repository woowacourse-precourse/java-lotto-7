package lotto.controller;

import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private InputView inputView;
    private OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void lottery() {
        PurchaseAmount purchaseAmount = initializePurchaseAmount();
        Lottos purchasedLottos = purchaseLottos(purchaseAmount);
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = new Lottos(purchaseAmount);
        outputView.printPurchaseLottos(lottos);

        return lottos;
    }

    private PurchaseAmount initializePurchaseAmount() {
        final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

        while (true) {
            try {
                String rawAmount = inputView.readLine(PURCHASE_AMOUNT_MESSAGE);
                long amount = Parser.stringToLong(rawAmount);

                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
