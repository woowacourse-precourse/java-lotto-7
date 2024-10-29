package lotto.service;

import lotto.domain.PurchasePrice;
import lotto.util.RetryUtil;
import lotto.view.InputView;

public class InputService {

    private final InputView inputView;

    public InputService(final InputView inputView) {
        this.inputView = inputView;
    }

    public PurchasePrice readPurchasePrice() {
        return RetryUtil.executeWithRetry(() -> {
            int purchasePrice = inputView.readPurchasePrice();
            return new PurchasePrice(purchasePrice);
        });
    }

}
