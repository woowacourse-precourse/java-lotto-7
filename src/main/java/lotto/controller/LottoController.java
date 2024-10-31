package lotto.controller;

import lotto.domain.*;
import lotto.strategy.LottoCreateStrategy;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static LottoCreateStrategy lottoCreateStrategy;
    private static LottoRankSummary lottoRankSummary;

    public LottoController(LottoCreateStrategy lottoCreateStrategy,
                           LottoRankSummary lottoRankSummary) {
        this.lottoCreateStrategy = lottoCreateStrategy;
        this.lottoRankSummary = lottoRankSummary;
    }

    public void input() {
        PurchaseAmount purchaseAmount = InputView.inputPurchaseAmount();
        WinningNumber winningNumber = InputView.inputWinningNumber();
        InputView.inputBonusNumber(winningNumber);
        List<Lotto> lottos = generateLotto(purchaseAmount);
        calculateLottoRank(lottos, winningNumber);
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

    private void calculateLottoRank(List<Lotto> lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            int correctCount = winningNumber.calculateCorrectCount(lotto);
            findOutRank(correctCount, winningNumber, lotto);
        }
    }

    private void findOutRank(int correctCount, WinningNumber winningNumber, Lotto lotto) {
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
