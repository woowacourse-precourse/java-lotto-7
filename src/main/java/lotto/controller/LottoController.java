package lotto.controller;

import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static LottoController getInstance() {
        return LottoControllerHolder.LOTTO_CONTROLLER;
    }

    public static class LottoControllerHolder {
        public static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    public void run() {
        int validPurchasePrice = validatePurchasePrice();
    }

    private int validatePurchasePrice() {
        boolean pass = false;
        String rawPurchasePrice = "";
        while (!pass) {
            rawPurchasePrice = inputView.getRequestPurchasePrice();
            pass = PurchasePriceValidator.validate(rawPurchasePrice);
        }
        return Integer.parseInt(rawPurchasePrice);
    }
}
