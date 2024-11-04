package lotto.controller;

import lotto.service.LottoService;
import lotto.util.InputHandler;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        int purchaseAmount = inputHandler.readPurchaseAmount();
        List<Integer> winningNumbers = inputHandler.readWinningNumbers();
        int bonusNumber = inputHandler.readBonusNumber();

        lottoService.playLotto(purchaseAmount, winningNumbers, bonusNumber);
    }
}