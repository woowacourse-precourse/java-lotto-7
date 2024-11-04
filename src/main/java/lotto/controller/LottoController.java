package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGame game;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoGame game, InputView inputView, OutputView outputView) {
        this.game = game;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int amount = inputView.purchase();
        game.purchaseTicket(amount);

        outputView.purchaseTickets(game.getTickets());

        game.setWinningNumber(inputView.winningNumber());
        game.setBonusNumber(inputView.bonusNumber());

        LottoResult result = game.calculateResult();

    }
}
