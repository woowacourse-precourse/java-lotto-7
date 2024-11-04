package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            int purchaseAmount = readPurchaseAmount();
            lottoService.generateLottos(purchaseAmount);
            OutputView.printPurchasedLottos(lottoService.getLottos());

            WinningLotto winningLotto = readWinningLotto();
            OutputView.printStatistics(
                    lottoService.calculateResults(winningLotto),
                    lottoService.calculateProfitRate(winningLotto, purchaseAmount)
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int readPurchaseAmount() {
        String input = InputView.inputPurchaseAmount();
        return Integer.parseInt(input);
    }

    private WinningLotto readWinningLotto() {
        String winningNumbersInput = InputView.inputWinningNumbers();
        String bonusNumberInput = InputView.inputBonusNumber();
        return new WinningLotto(
                LottoValidator.parseLottoNumbers(winningNumbersInput),
                Integer.parseInt(bonusNumberInput)
        );
    }
}