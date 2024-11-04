package lotto.controller;

import lotto.InputType;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGame game;
    private final InputView inputView;
    private final OutputView outputView;

    LottoController(LottoGame game, InputView inputView, OutputView outputView) {
        this.game = game;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void purchase() {
        String input = "";
        try {
            input = inputView.getInput(InputType.PURCHASE);
            game.validatePurchaseInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchase();
        }
        game.purchaseLottos(Integer.parseInt(input) / 1000);
    }

    public void displayLottos() {
        for (Lotto lotto : game.getLottos()) {
            outputView.printLottoNumbers(lotto.displayNumbers());
        }
    }
}
