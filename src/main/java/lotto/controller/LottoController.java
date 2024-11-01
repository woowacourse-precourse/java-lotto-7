package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        OutputView.printInputPurchaseAmountMessage();
        String purchaseAmountInput = InputView.getUserInput();
        OutputView.printInputWinningNumbers();
        String winningNumbersInput = InputView.getUserInput();
        OutputView.printInputBonusNumber();
        String bonusNumberInput = InputView.getUserInput();

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int lottoCount = purchaseAmount % 1000;
        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        
    }
}
