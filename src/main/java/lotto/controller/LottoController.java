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
        process(this::inputMoney);
        process(this::inputWinningNumbers);
        process(this::inputBonusNumber);
        process(this::result);
    }

    private void inputMoney() {
        OutputView.inputMoney();
        lottoService.setupMoney(InputView.money());
        OutputView.buyLottoTickets(lottoService.buyLottos());
    }

    private void inputWinningNumbers() {
        OutputView.inputWinningNumbers();
        List<Integer> winningNumbers = InputView.winningNumbers();
        lottoService.setupWinningNumbers(winningNumbers);
    }

    private void inputBonusNumber() {
        OutputView.bonusNumber();
        int bonusNumber = InputView.bonusNumber();
        lottoService.setupBonusNumber(bonusNumber);
    }

    private void result() {
        OutputView.result(lottoService.result());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.exception(e.getMessage());
            process(action);
        }
    }
}
