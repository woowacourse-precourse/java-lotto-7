package lotto.controller;

import lotto.domain.*;
import lotto.utils.LottoProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constants.ViewMessage.WINNING_STATISTICS;
import static lotto.view.InputView.readInput;

public class LottoController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = getLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        getWinningStatistics(lottos, winningNumbers, bonusNumber, purchaseAmount);
    }

    private void getWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        OutputView.printMessage(WINNING_STATISTICS.getText());
        List<LottoRankType> lottoRankTypes = LottoResult.of(lottos, winningNumbers, bonusNumber).getLottoRankTypes();
        String profitRate = LottoProfitCalculator.calculateProfitRate(lottoRankTypes, purchaseAmount);
        OutputView.printLottoProfitRate(profitRate);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumbersPrompt();
        return BonusNumber.of(winningNumbers, readInput()).getBonusNumber();
    }

    private List<Integer> getWinningNumbers() {
        InputView.printWinningNumbersPrompt();
        return WinningNumbers.from(readInput()).getNumbers();
    }

    private List<Lotto> getLottos(int purchaseAmount) {
        int lottoCount = LottoCount.from(purchaseAmount).getLottoCount();
        List<Lotto> lottos = Lottos.from(lottoCount).getLottos();
        OutputView.printLottoPurchaseCount(lottoCount);
        OutputView.printLottoListPrompt(lottos);
        return lottos;
    }

    private int getPurchaseAmount() {
        InputView.printPurchaseAmountPrompt();
        return LottoPurchaseAmount.from(readInput()).getPurchaseAmount();
    }

}