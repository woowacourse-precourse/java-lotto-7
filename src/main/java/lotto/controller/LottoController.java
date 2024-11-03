package lotto.controller;

import lotto.*;
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
        LottoPrizeMap lottoPrizeMap = new LottoPrizeMap();
        OutputView.outputWinningResult(lottoWinning, lottoPrizeMap);

        CalculateRateOfReturn calculateRateOfReturn
                = new CalculateRateOfReturn(purchaseAmount, lottoWinning, lottoPrizeMap);
    }
}
