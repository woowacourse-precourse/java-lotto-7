package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;
import lotto.util.*;

public class LottoController {

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
        String bonusNumberInput = InputView.inputWinningNumbers();

        return new WinningLotto(
                LottoValidator.parseLottoNumbers(winningNumbersInput),
                Integer.parseInt(bonusNumberInput)
        );
    }
}
