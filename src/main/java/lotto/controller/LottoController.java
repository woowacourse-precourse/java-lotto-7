package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    LottoInputView lottoInputView;
    LottoService lottoService;

    public LottoController() {
        lottoInputView = new LottoInputView();
        lottoService = new LottoService();
    }

    public void run() {
        lottoService.purchaseLottos(lottoInputView.getMoneyInput());
        lottoService.setWinningNumbers(lottoInputView.getNumbersInput());
        lottoService.setBonusWinningNumber(lottoInputView.getBonusNumberInput());
        lottoService.checkLottos();
        LottoOutputView.printWinningStatistics(lottoService.getWinningCount(), lottoService.calculateReturnRate());
    }
}
