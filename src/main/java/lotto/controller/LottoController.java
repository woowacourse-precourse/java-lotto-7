package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        String purchasePriceInput;

        int purchaseAmount = 0;

        while (true) {
            try {
                purchasePriceInput = inputView.inputPurchasePrice();
                purchaseAmount = lottoService.validatePurchasePrice(purchasePriceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        lottoService.generateLottoNumbers(purchaseAmount);
    }

}
