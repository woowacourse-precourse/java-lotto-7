package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.lottoService = new LottoService(inputView, outputView);
    }

    public void run() {
        lottoService.run();
    }
}