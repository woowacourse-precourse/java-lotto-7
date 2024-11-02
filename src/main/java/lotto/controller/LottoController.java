package lotto.controller;

import lotto.domain.*;
import lotto.strategy.LottoCreateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static LottoCreateStrategy lottoCreateStrategy;

    public LottoController(LottoCreateStrategy lottoCreateStrategy) {
        this.lottoCreateStrategy = lottoCreateStrategy;
    }

    public void start() {
        PurchaseAmount purchaseAmount = InputView.inputPurchaseAmount();
        WinningNumber winningNumber = InputView.inputWinningNumber();
        InputView.inputBonusNumber(winningNumber);
        List<Lotto> lottos = generateLotto(purchaseAmount);
        LottoRankSummary lottoRankSummary = calculateLottoRank(lottos, winningNumber);
        double rateOfReturn = lottoRankSummary.calculateRateOfReturn(purchaseAmount);
        OutputView.printResult(lottos, rateOfReturn, lottoRankSummary);
    }

    private List<Lotto> generateLotto(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCounts = purchaseAmount.findLottoCounts();

        while (lottoCounts > 0) {
            lottos.add(new Lotto(lottoCreateStrategy.createRandomLottoNumbers()));
            lottoCounts--;
        }

        return lottos;
    }

    private LottoRankSummary calculateLottoRank(List<Lotto> lottos, WinningNumber winningNumber) {
        LottoRankSummary lottoRankSummary = new LottoRankSummary();
        for (Lotto lotto : lottos) {
            int correctCount = winningNumber.calculateCorrectCount(lotto);
            findOutRank(correctCount, winningNumber, lotto, lottoRankSummary);
        }
        return lottoRankSummary;
    }

    private void findOutRank(int correctCount, WinningNumber winningNumber, Lotto lotto, LottoRankSummary lottoRankSummary) {
        if (correctCount == 3) {
            lottoRankSummary.incrementCount(LottoRank.FIFTH_RANK);
        } else if (correctCount == 4) {
            lottoRankSummary.incrementCount(LottoRank.FOURTH_RANK);
        } else if (correctCount == 5) {
            if (winningNumber.correctBonus(lotto)) {
                lottoRankSummary.incrementCount(LottoRank.SECOND_RANK);
            }
            lottoRankSummary.incrementCount(LottoRank.THIRD_RANK);
        } else if (correctCount == 6) {
            lottoRankSummary.incrementCount(LottoRank.FIRST_RANK);
        }
    }
}
