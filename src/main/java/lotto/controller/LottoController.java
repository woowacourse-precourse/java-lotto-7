package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.PurchasePrice;
import lotto.util.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private PurchasePrice initPurchasePrice() {
        return new PurchasePrice(Convertor.stringToInt(inputView.inputPurchasePrice()));
    }

    private LottoAmount calculateLottoAmount(PurchasePrice purchasePrice) {
        return new LottoAmount(purchasePrice.get());
    }

    private void printLottoAmount(LottoAmount lottoAmount) {
        outputView.printBuyLotto(lottoAmount.get());
    }

    public void run() {
        PurchasePrice purchasePrice = initPurchasePrice();
        LottoAmount lottoAmount = calculateLottoAmount(purchasePrice);
        printLottoAmount(lottoAmount);
    }
}
