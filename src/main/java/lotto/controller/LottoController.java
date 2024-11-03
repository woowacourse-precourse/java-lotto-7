package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        int purchaseAmount = InputView.purchaseAmount();
        int purchaseCount = lottoService.getPurchaseCount(purchaseAmount);
        OutputView.purchaseCount(purchaseCount);

        List<Lotto> lottos = lottoService.makeLottos(purchaseCount);
        OutputView.lottoNumbers(lottos);

        Lotto winningLotto = InputView.winningLotto();
    }
}
