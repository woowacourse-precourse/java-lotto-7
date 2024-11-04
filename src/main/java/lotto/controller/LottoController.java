package lotto.controller;

import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> lottos = lottoService.getLotto(purchaseAmount);
        OutputView.printLottos(lottos);

        InputLottoNumber inputLottoNumber = new InputLottoNumber(InputView.getWinningNumbers(), InputView.getBonusNumber());
    }
}
