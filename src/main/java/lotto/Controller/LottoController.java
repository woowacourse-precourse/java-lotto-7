package lotto.Controller;

import lotto.Input.InputView;
import lotto.Output.OutputView;
import lotto.Service.LottoService;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = inputView.readPurchaseAmount();
        outputView.printLottos(lottoService.purchaseLottos(purchaseAmount));
    }
}
