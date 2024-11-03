package controller;

import model.lotto.Lottos;
import model.money.Money;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Money purchaseAmount = inputView.readPurchaseAmount();
        int lottoCount = purchaseAmount.calculateLottoCount();
        Lottos lottos = lottoService.generate(lottoCount);
        outputView.displayLottos(lottos, lottoCount);


//        Lotto lotto = inputView.readWinningNumber();
//        Integer number = inputView.readBonus(lotto);
    }
}
