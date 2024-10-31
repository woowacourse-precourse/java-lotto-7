package lotto.controller;

import lotto.model.InputParser;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        this.inputView = InputView.getInstance();
    }

    public void startLottoSaleProcess() {
        InputParser inputParser = new InputParser();
        int purchaseAmount = getPurchaseAmount(inputParser);
    }

    public int getPurchaseAmount(InputParser inputParser) {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                return inputParser.parsePurchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
