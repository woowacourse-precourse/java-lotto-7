package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.sevice.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int purchaseCount = InputView.requestPurchaseAmount();
        List<Lotto> lottos = lottoService.issueLottos(purchaseCount);
        OutputView.printLottos(lottos);
        WinningLotto winningLotto = new WinningLotto(InputView.requestWinningNumbers(), InputView.requestBonusNumber());
        LottoResult result = lottoService.winningProgress(lottos, winningLotto);
        OutputView.printStatistics(result);
    }
}
