package lotto.controller;

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
        lottoService.setupWinningNumbers(InputView.winningNumbers());
    }

    private void inputBonusNumber() {
        OutputView.bonusNumber();
        lottoService.setupBonusNumber(InputView.bonusNumber());
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
