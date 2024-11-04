package lotto.controller;

import lotto.model.lotto.LottoTickets;
import lotto.util.RetryTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoController lottoController;
    private final WinningController winningController;

    public LottoGameController(InputView inputView, OutputView outputView, RetryTemplate retryTemplate) {
        this.lottoController = new LottoController(inputView, outputView, retryTemplate);
        this.winningController = new WinningController(inputView, outputView, retryTemplate);
    }

    public void play() {
        LottoTickets tickets = lottoController.buyLottoTickets();
        winningController.processWinningResult(tickets);
    }
}