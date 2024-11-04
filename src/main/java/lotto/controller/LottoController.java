package lotto.controller;

import lotto.draw.DrawView;
import lotto.draw.model.BonusNumber;
import lotto.draw.model.DrawNumbers;
import lotto.purchase.PurchaseView;
import lotto.purchase.model.Purchase;
import lotto.result.ResultView;
import lotto.result.model.LottoWinCount;
import lotto.result.model.Profit;

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
        DrawView drawView = new DrawView();
        while (true) {
            try {
                String drawNumbersInput = drawView.readDrawNumber();
                drawNumbers = new DrawNumbers(drawNumbersInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        while (true) {
            try {
                String bonusNumberInput = drawView.readBonusNumber();
                bonusNumber = new BonusNumber(bonusNumberInput, drawNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void lottoResult() {
        ResultView resultView = new ResultView();
        LottoWinCount lottoWinCount = new LottoWinCount(drawNumbers, bonusNumber, purchase.getPurchasedLottoTickets());
        Profit profit = new Profit(lottoWinCount.getLottoWinCount(), purchase.getPayment());
        resultView.displayLottoWins(lottoWinCount.getLottoWinCount());
        resultView.displayProfit(profit.getProfit());
    }
}
