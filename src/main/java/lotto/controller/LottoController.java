package lotto.controller;

import lotto.domain.*;
import lotto.strategy.RandomLottoCreateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        Budget budget = setUpBudget();
        List<Lotto> lottoTickets = buyLotto(budget);

        WinningNumber winningNumber = setUpWinningNumber();

        LottoSummary lottoSummary = new LottoSummary(lottoTickets, winningNumber);
        double rateOfReturn = lottoSummary.calculateRateOfReturn(budget);
        OutputView.printResult(lottoTickets, rateOfReturn, lottoSummary);
    }

    private Budget setUpBudget() {
        try {
            return new Budget(InputView.inputBudget());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return setUpBudget();
        }
    }

    private List<Lotto> buyLotto(Budget budget) {
        return LottoGenerator.generateLotto(budget, new RandomLottoCreateStrategy());
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
}
