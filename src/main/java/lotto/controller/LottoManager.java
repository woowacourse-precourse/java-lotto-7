package lotto.controller;

import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();
    private InputParser inputParser = new InputParser();
    private OutputView outputView = new OutputView();
    public void startLotto() {
        int purchasePrice = getPurchasePrice();

    }

    private int getPurchasePrice() {
        int parsedPurchasePrice = 0;
        while (true) {
            try {
                String purchasePrice = inputView.getPurchasePrice();
                inputValidator.validatePurchasePrice(purchasePrice);
                parsedPurchasePrice = inputParser.parsePurchasePrice(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return parsedPurchasePrice;
    }
}
