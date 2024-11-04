package lotto.controller;

import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> lottos = lottoService.getLotto(purchaseAmount);
        OutputView.printLottos(lottos);

        InputLottoNumber inputLottoNumber = new InputLottoNumber(InputView.getWinningNumbers(), InputView.getBonusNumber());
        Map<Rank, Integer> rankResult = lottoService.getRankResult(lottos, inputLottoNumber);
        OutputView.printRankResult(rankResult);

        int totalPrize = lottoService.calculateTotalPrize(rankResult);
        double yield = lottoService.calculateYield(totalPrize, purchaseAmount);
        OutputView.printYield(yield);
    }
}
