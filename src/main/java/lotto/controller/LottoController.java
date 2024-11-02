package lotto.controller;

import lotto.model.LottoDraw;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.model.Purchase;
import lotto.view.LottoDrawView;
import lotto.view.LottoResultView;
import lotto.view.PurchaseView;

public class LottoController {
    private Purchase purchase;
    private LottoDraw lottoDraw;

    public void purchaseLotto() {
        PurchaseView purchaseView = new PurchaseView();
        String paymentInput = purchaseView.readPayment();
        purchase = new Purchase(paymentInput);
        purchaseView.displayPurchaseResult(purchase.getLottoCount(), purchase.getPurchasedLottoTickets());
    }

    public void drawLotto() {
        LottoDrawView lottoDrawView = new LottoDrawView();
        String drawNumbersInput = lottoDrawView.readDrawNumber();
        LottoNumbers drawNumbers = new LottoNumbers(drawNumbersInput);
        String bonusNumberInput = lottoDrawView.readBonusNumber();
        lottoDraw = new LottoDraw(drawNumbers, bonusNumberInput);
    }

    public void lottoResult() {
        LottoResultView lottoResultView = new LottoResultView();
        LottoResult lottoResult = new LottoResult(lottoDraw, purchase.getPurchasedLottoTickets(),
                purchase.getPayment());
        lottoResultView.displayLottoWins(lottoResult.getLottoWinCount());
        lottoResultView.displayProfit(lottoResult.getLottoProfit());
    }
}
