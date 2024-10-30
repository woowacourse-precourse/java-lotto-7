package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.validator.exception.LottoException;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void startLottoSimulation() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                Lottos lottos = lottoService.purchaseLotto(purchaseAmount);
                outputView.displayLottos(lottos);
                break;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }
}
