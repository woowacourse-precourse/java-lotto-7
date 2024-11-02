package lotto.controller;

import lotto.domain.*;
import lotto.strategy.RandomLottoCreateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        Budget budget = setUpBudget();
        WinningNumber winningNumber = setUpWinningNumber();
        List<Lotto> lottoTickets = buyLotto(budget);
        LottoRankSummary lottoRankSummary = calculateLottoRank(lottoTickets, winningNumber);
        double rateOfReturn = lottoRankSummary.calculateRateOfReturn(budget);
        OutputView.printResult(lottoTickets, rateOfReturn, lottoRankSummary);
    }

    private Budget setUpBudget() {
        try {
            return new Budget(InputView.inputBudget());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return setUpBudget();
        }
    }

    private WinningNumber setUpWinningNumber() {
        try {
            List<Integer> winningNumber = InputView.inputWinningNumber();
            int bonusNumber = InputView.inputBonusNumber();
            return new WinningNumber(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return setUpWinningNumber();
        }
    }

    private List<Lotto> buyLotto(Budget budget) {
        return LottoGenerator.generateLotto(budget, new RandomLottoCreateStrategy());
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
