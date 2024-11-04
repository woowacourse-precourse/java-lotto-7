package lotto.controller;

import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public PurchaseLotto purchaseLotto() {
        while (true) {
            try {
                int amount = InputView.inputPurchaseAmount();
                return lottoService.purchase(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void registerWinningLotto() {
        winningLotto();
        bonusNumber();
    }

    public LottoResult getLottoResult() {
        return lottoService.getWinningResult();
    }

    private void winningLotto() {
        while (true) {
            try {
                List<Integer> winnerNumber = InputView.winnerNumber();
                lottoService.registerWinningLotto(winnerNumber);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void bonusNumber() {
        while (true) {
            try {
                int number = InputView.inputBonusNumber();
                lottoService.registerBonusNumber(number);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
