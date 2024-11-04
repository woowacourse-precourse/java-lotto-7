package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPriceMap;
import lotto.service.LottoWinning;
import lotto.service.CalculateProfitRate;
import lotto.service.RandomNumbersDraw;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {
    private int purchaseAmount;
    private LottoDraw lottoDraw;
    private Lotto winningNumbers;
    private int bonusNumber;

    public void run() {
        inputPurchaseAmount();
        inputWinningNumbers();
        inputBonusNumber();

        LottoWinning lottoWinning = new LottoWinning(winningNumbers.getNumbers(), bonusNumber, lottoDraw.getLottoDrawNumbers());
        LottoPriceMap lottoPriceMap = new LottoPriceMap();
        OutputView.outputWinningResult(lottoWinning.getWinningLotto(), lottoPriceMap.getPrizes());

        CalculateProfitRate calculateRateOfReturn
                = new CalculateProfitRate(purchaseAmount, lottoWinning.getWinningLotto(), lottoPriceMap.getPrizes());
        OutputView.outputRateOfReturn(calculateRateOfReturn.getProfitRate());
    }

    private void inputPurchaseAmount() {
        while (true) {
            try {
                purchaseAmount = InputView.inputPurchaseAmount();

                RandomNumbersDraw randomNumbersDraw = new RandomNumbersDraw();
                List<Lotto> lottoDrawNumbers = randomNumbersDraw.randomLottoNumberDraw(purchaseAmount);
                lottoDraw = new LottoDraw(purchaseAmount, lottoDrawNumbers);
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
