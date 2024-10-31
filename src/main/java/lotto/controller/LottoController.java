package lotto.controller;

import java.util.List;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        inputMoney();
        buyTickets();
        inputWinningNumbers();
        result();
    }

    private void inputMoney() {
        OutputView.money();
        lottoService.setupMoney(InputView.money());
    }

    private void buyTickets() {
        OutputView.buyLottoTickets(lottoService.buyTickets());
    }

    private void inputWinningNumbers() {
        OutputView.winningNumbers();
        List<Integer> winningNumbers = InputView.winningNumbers();

        OutputView.bonusNumber();
        int bonusNumber = InputView.bonusNumber();

        lottoService.setupWinningNumbers(winningNumbers, bonusNumber);
    }

    private void result() {
        OutputView.result(lottoService.result());
    }
}
