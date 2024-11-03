package lotto.controller;

import lotto.service.LottoService;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        Money money = new Money(inputView.getPurchasedMoney());
        Lotto[] issuedLottos = lottoService.issueLotto(money);
        lottoService.showLottoNumbers(issuedLottos);

        Lotto lotto = new Lotto(inputView.getWinningNumbers());
        lotto.addBonusNumber(inputView.getBonusNumber());

        lottoService.countMatchingNumbers(issuedLottos, lotto);
        lottoService.showWinningStatistics();

        double profitRate = lottoService.calculateProfitRate(money);
        lottoService.showProfitRate(profitRate);
    }
}
