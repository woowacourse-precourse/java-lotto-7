package lotto.controller;

import lotto.domain.model.LottoResult;
import lotto.domain.dto.WinningLottoForm;
import lotto.domain.model.Lottos;
import lotto.domain.dto.MoneyForm;
import lotto.domain.result.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        Lottos lottos = purchaseLottos();

        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = lottoService.checkLottoResult(lottos, winningLotto);
        outputView.printLottoResult(lottoResult);
    }

    private Lottos purchaseLottos() {
        MoneyForm moneyForm = inputView.createMoneyForm();
        Lottos lottos = lottoService.purchaseLottos(moneyForm.getMoney());
        outputView.printBoughtLottos(lottos.getLottos());
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        WinningLottoForm form = inputView.createWinningLottoForm();
        return lottoService.createWinningLotto(form.getWinningNumbers(), form.getBonusNumber());
    }
}
