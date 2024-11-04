package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottery;
import lotto.domain.LottoResult;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchaseLotto;
import lotto.domain.PurchasePrice;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningNumber;
import lotto.handler.InputHandler;
import lotto.view.OutputView;

public class LottoController {

    private final NumberGenerator lottoNumberGenerator;

    public LottoController(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        Lottery lottery = prepareLottery();
        startLottery(lottery);
    }

    private void startLottery(Lottery lottery) {
        LottoResult lottoResult = lottery.createLottoResult();
        OutputView.printWinningResult(lottoResult);
        OutputView.printRateOfReturn(new RateOfReturn(lottoResult));
    }

    private Lottery prepareLottery() {
        OutputView.printPurchaseInputText();
        PurchasePrice purchasePrice = InputHandler.receiveValidatedPurchasePrice();
        PurchaseLotto purchaseLotto = createLottoTickets(purchasePrice);
        OutputView.printWinningNumberInputText();
        WinningNumber winningNumber = InputHandler.receiveValidatedWinningNumber();
        OutputView.printBonusNumberInputText();
        BonusNumber bonusNumber = InputHandler.receiveValidatedBonusNumber(winningNumber);
        return new Lottery(purchaseLotto, winningNumber, bonusNumber);
    }

    private PurchaseLotto createLottoTickets(PurchasePrice purchasePrice) {
        PurchaseLotto purchaseLotto = PurchaseLotto.of(purchasePrice, lottoNumberGenerator);
        OutputView.printPurchasedCount(purchaseLotto);
        OutputView.printPurchasedLottoTickets(purchaseLotto);
        return purchaseLotto;
    }


}
