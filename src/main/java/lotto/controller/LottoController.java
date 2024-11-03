package lotto.controller;

import lotto.model.LottoGame;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(OutputView outputView, LottoGame lottoGame) {
        this.outputView = outputView;
        this.lottoGame = lottoGame;
    }

    public void LottoGameStart() {
        outputView.printPriceInputPrompt();
        lottoGame.start();

    }
}
