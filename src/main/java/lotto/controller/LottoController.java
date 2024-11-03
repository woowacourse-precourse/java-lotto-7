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

        LottoSummary lottoSummary = new LottoSummary(lottoTickets, winningNumber, budget);

        OutputView.printResult(lottoTickets, lottoSummary);
    }

    private Budget setUpBudget() {
        try {
            return new Budget(InputView.inputBudget());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpBudget();
        }
    }

    private List<Lotto> buyLotto(Budget budget) {
        return LottoGenerator.generateLotto(budget, new RandomLottoCreateStrategy());
    }

    private WinningNumber setUpWinningNumber() {
        try {
            Lotto winningNumber = new Lotto(InputView.inputWinningNumber());
            int bonusNumber = InputView.inputBonusNumber();
            return new WinningNumber(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpWinningNumber();
        }
    }
}
