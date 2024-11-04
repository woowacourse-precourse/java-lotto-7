package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.*;
import lotto.view.OutputView;

import java.util.List;

public class LottoPrizeController {
    private int prize = 0;

    public void calculatePrize(Lotto winnerLottoNumber, int bonusNumber, List<Lotto> userLottoNumbers, String amount) {
        for (Lotto userNumber : userLottoNumbers) {
            prize += LottoCalculator.calculatePrize(userNumber.getNumbers(), winnerLottoNumber.getNumbers(), bonusNumber);
        }
        printPrize(amount);
    }

    private void printPrize(String amount) {
        OutputView.printStatics(LottoCalculator.getFinalMatchNumbers(), RateOfReturnCalculator.calculateRateOfReturn(Integer.parseInt(amount), prize));
    }
}