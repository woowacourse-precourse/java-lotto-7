package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.Output;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private InputValidator inputController = new InputValidator();
    private Output output = new Output();

    public void buyLotto() {
        int buyMoney = inputController.readBuyLotto();

        List<Lotto> lottos = lottoService.buyLottos(buyMoney);
        output.printPurchasedLottos(lottos);

        Lotto winningLotto = inputController.readWinningLotto();

        inputController.makeBonusNumber(winningLotto);

        LottoResult lottoResult = lottoService.matchLotto(lottos, winningLotto);

        double yeild = lottoService.getYield(buyMoney, lottoResult.getTotalPrizeAmount());

        output.printLottoResult(lottoResult);
        output.printYield(yeild);
    }
}
