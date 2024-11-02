package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        int lottoCount = Integer.parseInt(purchaseAmount) / 1000;
        lottoService.generateLottos(lottoCount);
        outputView.printLottoCount(lottoCount);
        List<Lotto> lottos = lottoService.getLottos();
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }
}
