package lotto.controller;

import lotto.InputParser;
import lotto.InputView;
import lotto.Lotto;
import service.LottoService;
import service.LottoServiceImpl;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoServiceImpl();
    }

    public void startLotto() {
        int purchaseAmount = InputParser.parsePurchaseAmount(InputView.getLottoPurchaseAmount());
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
    }
}
