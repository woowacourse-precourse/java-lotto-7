package lotto.controller;

import lotto.model.Consumer;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        Consumer consumer = new Consumer(InputView.getLottoCount());
        OutputView.printLottoTicket(consumer);
        List<Integer> mainNumber = InputView.getWinningNumber();
        Integer bonusNumber = InputView.getBonusNumber(mainNumber);
        WinningNumber winningNumber = new WinningNumber(mainNumber, bonusNumber);
        consumer.setLottoResult(winningNumber);
        OutputView.printResult(consumer.getLottoResult(), consumer.getSecondPlace());
    }
}