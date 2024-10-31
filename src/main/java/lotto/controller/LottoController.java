package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.LottoNumber;
import lotto.model.PurchasePrice;
import lotto.model.RandomNumber;
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

    private LottoNumber createLottoNumber(LottoAmount lottoAmount, RandomNumber randomNumber) {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.add(lottoAmount, randomNumber);
        return lottoNumber;
    }

    private void printLottoNumber(LottoNumber lottoNumber) {
        outputView.printLottoNumber(lottoNumber.get());
    }

    public void run() {
        PurchasePrice purchasePrice = initPurchasePrice();
        LottoAmount lottoAmount = calculateLottoAmount(purchasePrice);
        printLottoAmount(lottoAmount);

        RandomNumber randomNumber = new RandomNumber();
        LottoNumber lottoNumber = createLottoNumber(lottoAmount, randomNumber);
        printLottoNumber(lottoNumber);
    }
}
