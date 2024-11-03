package lotto.controller;

import lotto.Lotto;
import lotto.LottoDraw;
import lotto.LottoWinning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoDraw lottoDraw = new LottoDraw(purchaseAmount);
        OutputView.outputNumberOfPurchaseLotto(lottoDraw);

        Lotto winningNumbers = new Lotto(InputView.inputLottoPrizeNumbers());
        int bonusNumber = InputView.inputLottoBonusNumber();
        LottoWinning lottoWinning = new LottoWinning(winningNumbers, bonusNumber, lottoDraw);
        OutputView.outputWinningResult(lottoWinning);
    }
}
