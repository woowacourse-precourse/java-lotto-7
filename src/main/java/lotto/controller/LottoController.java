package lotto.controller;

import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoValidation lottoValidation;

    public LottoController(OutputView outputView, InputView inputVIew, LottoValidation lottoValidation) {
        this.outputView = outputView;
        this.inputView = inputVIew;
        this.lottoValidation = lottoValidation;
    }

    public void run() {
        outputView.askPurchasePrice();
        int purchasePrice = getValidPurchasePrice();
    }

    private int getValidPurchasePrice() {
        while (true) {
            try {
                String unValidPurchasePrice = inputView.inputPurchasePrice();

                lottoValidation.validateBlank(unValidPurchasePrice);
                lottoValidation.validateParsing(unValidPurchasePrice);

                return Integer.parseInt(unValidPurchasePrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
