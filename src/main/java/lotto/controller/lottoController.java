package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class lottoController {
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void lotto() {
        String moneyInput = inputView.inputMoney();
        lottoService.checkAndConvertInputMoney(moneyInput);
    }
}
