package lotto.service;

import lotto.controller.LottoController;
import lotto.dto.request.DrawRequest;
import lotto.dto.request.MoneyRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class Starter {
    private final LottoController lottoController;

    public Starter(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        int money = getMoney();
        List<List<Integer>> tickets = runBuyTicket(money);
        runDrawLotto(money, tickets);
    }

    private int getMoney() {
        return InputView.getMoney();
    }

    private List<List<Integer>> runBuyTicket(int money) {
        List<List<Integer>> tickets = lottoController.buyTicket(MoneyRequest.of(money)).tickets();

        OutputView.printTicketsInfo(tickets);

        return tickets;
    }

    private void runDrawLotto(int money, List<List<Integer>> tickets) {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        Integer bonusNumber = InputView.getBonusNumber(winningNumbers);

        int[] result = lottoController.draw(DrawRequest.of(tickets, winningNumbers, bonusNumber));

        OutputView.printResult(result, lottoController.calculateProfitRate(money, result));
    }
}
