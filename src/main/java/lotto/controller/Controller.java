package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        Integer totalMoney;
        Lotteries lotteries;

        while (true) {
            try {
                totalMoney = inputView.inputTotalMoney();
                lotteries = new Lotteries(totalMoney);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printOutput(e.getMessage());
            }
        }

        outputView.printOutput(lotteries.formatOutput());

        Lotto lotto;

        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                lotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printOutput(e.getMessage());
            }
        }

        WinningLotto winningLotto;
        Integer bonusNumber;

        while (true) {
            try {
                bonusNumber = inputView.inputBonusNumber();
                winningLotto = new WinningLotto(lotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printOutput(e.getMessage());
            }
        }

        Prizes prizes = lotteries.getPrizes(winningLotto);
        outputView.printOutput(prizes.formatDescriptions());
        Yield yield = new Yield(totalMoney);
        prizes.sumRewards(yield);
        outputView.printOutput(prizes.formatYieldRatio(yield));
    }
}
