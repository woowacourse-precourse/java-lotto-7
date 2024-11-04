package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPrizeMap;
import lotto.service.LottoWinning;
import lotto.service.CalculateProfitRate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private int purchaseAmount;
    private LottoDraw lottoDraw;
    private Lotto winningNumbers;
    private int bonusNumber;

    public void run() {
        inputPurchaseAmount();
        inputWinningNumbers();
        inputBonusNumber();

        LottoWinning lottoWinning = new LottoWinning(winningNumbers, bonusNumber, lottoDraw.getLottoDrawNumbers());
        LottoPrizeMap lottoPrizeMap = new LottoPrizeMap();
        OutputView.outputWinningResult(lottoWinning, lottoPrizeMap);

        CalculateProfitRate calculateRateOfReturn
                = new CalculateProfitRate(purchaseAmount, lottoWinning, lottoPrizeMap);
        OutputView.outputRateOfReturn(calculateRateOfReturn);
    }

    private void inputPurchaseAmount() {
        while (true) {
            try {
                purchaseAmount = InputView.inputPurchaseAmount();

                lottoDraw = new LottoDraw(purchaseAmount);
                OutputView.outputNumberOfPurchaseLotto(lottoDraw);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputWinningNumbers() {
        while(true){
            try {
                winningNumbers = new Lotto(InputView.inputLottoNumbers());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while(true){
            try {
                bonusNumber = InputView.inputLottoBonusNumber(winningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
