package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private Input input = new Input();
    private Output output = new Output();

    public void buyLotto() {
        int buyMoney = input.readLottoAmount();
        List<Lotto> lottos = lottoService.buyLottos(buyMoney);
        output.printPurchasedLottos(lottos);

        Lotto winningLotto = new Lotto(input.readWinningNumber());

        new BonusNumber(input.readBonusNumber(), winningLotto);

        LottoResult lottoResult = lottoService.matchLotto(lottos, winningLotto);

        double yeild = lottoService.getYield(buyMoney, lottoResult.getTotalPrizeAmount());

        output.printLottoResult(lottoResult);
        output.printYield(yeild);
    }
}
