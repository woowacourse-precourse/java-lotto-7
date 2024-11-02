package lotto;

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
        String paymentInput = purchaseView.getPayment();
        purchase = new Purchase(paymentInput);
        purchaseView.displayPurchaseResult(purchase.getLottoCount(), purchase.getPurchasedLottoTickets());
    }

    public void drawLotto() {
        LottoDrawView lottoDrawView = new LottoDrawView();
        String drawNumbersInput = lottoDrawView.getDrawNumbers();
        LottoNumbers drawNumbers = new LottoNumbers(drawNumbersInput);
        String bonusNumberInput = lottoDrawView.getBonusNumber();
        lottoDraw = new LottoDraw(drawNumbers, bonusNumberInput);
    }

    public void lottoResult() {
        LottoResultView lottoResultView = new LottoResultView();
        LottoResult lottoResult = new LottoResult(lottoDraw, purchase.getPurchasedLottoTickets(),
                purchase.getPayment());
        lottoResultView.displayLottoWins(lottoResult.getLottoWinCount());
        lottoResultView.getProfit();
    }
}
