package lotto.service;

import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class InputService {

    private final InputView inputView;

    private final OutputView outputView;

    public InputService(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public PurchasePrice parsePurchasePrice() {
        return executeWithRetry(() -> {
            int purchasePrice = inputView.readPurchasePrice();
            return new PurchasePrice(purchasePrice);
        });
    }

    private <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
