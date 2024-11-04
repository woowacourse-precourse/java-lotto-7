package lotto.controller;

import lotto.model.Lotteries;
import lotto.model.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Lotteries lotteries;

    public Controller(InputView inputView, OutputView outputView, Lotteries lotteries) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lotteries = lotteries;

        Integer amount = inputView.inputAmount();
        lotteries.buyLotteries(amount);
        OutputView.printOutput(lotteries.formatOutput());

        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        Integer bonusNumber = inputView.inputBonusNUmber();

        Prizes prizes = lotteries.getPrizes(winningNumbers, bonusNumber);
        OutputView.printOutput(prizes.formatDescriptions());
    }
}
