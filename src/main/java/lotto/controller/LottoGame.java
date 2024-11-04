package lotto.controller;

import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGameService = new LottoGameService();
    }

    public void start() {

    }
}
