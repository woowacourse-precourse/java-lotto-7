package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void lotto() {
        processInputMoney();

        List<Lotto> lottos = lottoService.generateLottos();
        outputView.printNumOfLottos(lottos.size());
        for (Lotto lotto : lottos) {
            outputView.printLotto(lotto.getNumbers());
        }

        processInputWinningNumber();
    }

    private void processInputMoney() {
        String moneyInput = inputView.inputMoney();
        try {
            lottoService.checkAndConvertInputMoney(moneyInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            processInputMoney();
        }
    }

    private void processInputWinningNumber() {
        String winningNumberInput = inputView.inputWinningNumber();
        try {
            lottoService.checkAndConvertInputWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            processInputWinningNumber();
        }
    }
}
