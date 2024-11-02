package lotto.controller;

import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
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

        int lottoCount = getLottoCount(purchasePrice);
    }

    private int getValidPurchasePrice() {
        while (true) {
            try {
                String input = inputView.inputPurchasePrice();

                lottoValidation.validateBlank(input);
                int purchasePrice = lottoValidation.validateParsing(input);
                lottoValidation.validatePositive(purchasePrice);
                lottoValidation.validateDivisible(purchasePrice);

                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getLottoCount(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }
}
