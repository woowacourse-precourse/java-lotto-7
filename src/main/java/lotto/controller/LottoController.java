package lotto.controller;

import lotto.model.draw.DrawNumber;
import lotto.model.draw.LottoNumbers;
import lotto.model.purchase.Purchase;
import lotto.model.result.LottoResult;
import lotto.view.LottoDrawView;
import lotto.view.LottoResultView;
import lotto.view.PurchaseView;

public class LottoController {
    private Purchase purchase;
    private DrawNumber drawNumber;

    public void purchaseLotto() {
        PurchaseView purchaseView = new PurchaseView();
        while (true) {
            try {
                String paymentInput = purchaseView.readPayment();
                purchase = new Purchase(paymentInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage() + "\n");
            }
        }
        purchaseView.displayPurchaseResult(purchase.calculateLottoCount(), purchase.getPurchasedLottoTickets());
    }

    public void drawLotto() {
        LottoDrawView lottoDrawView = new LottoDrawView();
        String drawNumbersInput = lottoDrawView.readDrawNumber();
        LottoNumbers drawNumbers = new LottoNumbers(drawNumbersInput);
        String bonusNumberInput = lottoDrawView.readBonusNumber();
        drawNumber = new DrawNumber(drawNumbers, bonusNumberInput);
    }

    public void lottoResult() {
        LottoResultView lottoResultView = new LottoResultView();
        LottoResult lottoResult = new LottoResult(drawNumber, purchase.getPurchasedLottoTickets(),
                purchase.getPayment());
        lottoResultView.displayLottoWins(lottoResult.getLottoWinCount());
        lottoResultView.displayProfit(lottoResult.getLottoProfit());
    }
}
