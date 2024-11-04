package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, LottoService lottoService) {
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        process(this::inputMoney);
        process(this::inputWinningNumbers);
        process(this::inputBonusNumber);
        process(this::result);
    }

    private void inputMoney() {
        outputView.inputMoney();
        lottoService.setupMoney(InputView.money());
        outputView.buyLottoTickets(lottoService.buyLottos());
    }

    private void inputWinningNumbers() {
        outputView.inputWinningNumbers();
        lottoService.setupWinningNumbers(InputView.winningNumbers());
    }

    private void inputBonusNumber() {
        outputView.bonusNumber();
        lottoService.setupBonusNumber(InputView.bonusNumber());
    }

    private void result() {
        outputView.result(lottoService.result());
        InputView.close();
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.exception(e.getMessage());
            process(action);
        }
    }
}
