package lotto.controller;

import lotto.model.Game;
import lotto.model.purchase.PurchaseAmountConverter;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final Game game;

    public LottoController(View view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() {
        handleLottoPurchase();
    }

    private <T> void executeWithRetry(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                view.displayException(e.getMessage());
            }
        }
    }

    private void handleLottoPurchase() {
        executeWithRetry(this::purchaseLottos);
    }

    private void purchaseLottos() {
        String input = view.promptPurchaseAmount();
        int amount = PurchaseAmountConverter.convert(input);
        game.purchaseLottos(amount);
    }
}
