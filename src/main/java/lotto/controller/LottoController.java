package lotto.controller;

import lotto.domain.*;
import lotto.domain.LottoProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.common.constants.ViewMessage.WINNING_STATISTICS;
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
        List<LottoRankType> lottoRankTypes = calculateLottoResults(lottos, winningNumbers, bonusNumber);
        String profitRate = calculateProfitRate(lottoRankTypes, purchaseAmount);
        displayStatistics(lottoRankTypes, profitRate);
    }

    private List<LottoRankType> calculateLottoResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return LottoResult.of(lottos, winningNumbers, bonusNumber).getLottoRankTypes();
    }

    private String calculateProfitRate(List<LottoRankType> lottoRankTypes, int purchaseAmount) {
        return LottoProfitCalculator.from(lottoRankTypes, purchaseAmount).getLottoProfitRate();
    }

    private void displayStatistics(List<LottoRankType> lottoRankTypes, String profitRate) {
        OutputView.printLottoResultPrompt(lottoRankTypes);
        OutputView.printLottoProfitRate(profitRate);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumbersPrompt();
        try {
            return BonusNumber.of(winningNumbers, readInput()).getBonusNumber();
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private List<Integer> getWinningNumbers() {
        InputView.printWinningNumbersPrompt();
        try {
            return WinningNumbers.from(readInput()).getNumbers();
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            return getWinningNumbers();
        }
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
        try {
            return LottoPurchaseAmount.from(readInput()).getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

}