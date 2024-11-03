package lotto.controller;

import lotto.model.draw.BonusNumber;
import lotto.model.draw.DrawNumbers;
import lotto.model.purchase.Purchase;
import lotto.model.result.LottoResult;
import lotto.view.LottoDrawView;
import lotto.view.LottoResultView;
import lotto.view.PurchaseView;

public class LottoController {
    private Purchase purchase;
    private DrawNumbers drawNumbers;
    private BonusNumber bonusNumber;

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
        while (true) {
            try {
                String drawNumbersInput = lottoDrawView.readDrawNumber();
                drawNumbers = new DrawNumbers(drawNumbersInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        while (true) {
            try {
                String bonusNumberInput = lottoDrawView.readBonusNumber();
                bonusNumber = new BonusNumber(bonusNumberInput, drawNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void lottoResult() {
        LottoResultView lottoResultView = new LottoResultView();
        LottoResult lottoResult = new LottoResult(drawNumbers, bonusNumber, purchase.getPurchasedLottoTickets(),
                purchase.getPayment());
        lottoResultView.displayLottoWins(lottoResult.getLottoWinCount());
        lottoResultView.displayProfit(lottoResult.getLottoProfit());
    }
}
