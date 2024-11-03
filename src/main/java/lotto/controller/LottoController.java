package lotto.controller;

import lotto.model.LottoGame;
import lotto.view.InputView;

public class LottoController {
    private final LottoGame game;
    private final InputView inputView;

    public LottoController(LottoGame game, InputView inputView) {
        this.game = game;
        this.inputView = inputView;
    }

    public void run() {
        int amount = inputView.purchase();
        game.purchaseTicket(amount);

        // 구입한 로또 출력 구현 필요

        game.setWinningNumber(inputView.winningNumber());
        game.setBonusNumber(inputView.bonusNumber());

        // 결과 출력 구현 필요
    }
}
