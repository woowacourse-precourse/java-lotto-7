package lotto.controller;

import lotto.domain.*;
import lotto.utils.LottoProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constants.ViewMessage.PROFIT_RATE;
import static lotto.constants.ViewMessage.WINNING_STATISTICS;
import static lotto.view.InputView.readInput;


public class LottoController {

    public void run() {
        InputView.printPurchaseAmountPrompt();
        int purchaseAmount = LottoPurchaseAmount.from(readInput()).getPurchaseAmount();

        int lottoCount = LottoCount.from(purchaseAmount).getLottoCount();
        List<Lotto> lottos = Lottos.from(lottoCount).getLottos();
        OutputView.printLottoPurchaseCount(lottoCount);
        OutputView.printLottoListPrompt(lottos);

        InputView.printWinningNumbersPrompt();
        List<Integer> winningNumbers = WinningNumbers.from(readInput()).getNumbers();

        InputView.printBonusNumbersPrompt();
        int bonusNumber = BonusNumber.of(winningNumbers, readInput()).getBonusNumber();

        OutputView.printMessage(WINNING_STATISTICS.getText());
        List<LottoRankType> lottoRankTypes = LottoResult.of(lottos, winningNumbers, bonusNumber).getLottoRankTypes();
        String profitRate = LottoProfitCalculator.calculateProfitRate(lottoRankTypes, purchaseAmount);
        OutputView.printLottoProfitRate(profitRate);
    }

}