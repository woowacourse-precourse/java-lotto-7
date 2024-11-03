package lotto.controller;

import java.util.List;
import lotto.model.Lottos;
import lotto.model.WinningStatistic;
import lotto.service.LottoFacade;
import lotto.util.Parser;
import lotto.view.ViewFacade;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoFacade lottoFacade;

    public LottoController(ViewFacade viewFacade, LottoFacade lottoFacade) {
        this.viewFacade = viewFacade;
        this.lottoFacade = lottoFacade;
    }

    public void run() {
        String costInput = viewFacade.getCost();
        int cost = Parser.parseToInt(costInput);
        int purchaseAmount = Parser.parsePurchaseAmount(cost);

        Lottos lottos = lottoFacade.issueLottos(purchaseAmount);
        viewFacade.showLottos(purchaseAmount, lottos);

        String winningNumbersInput = viewFacade.getWinningNumbers();
        List<Integer> winningNumbers = Parser.parseWinningNumbers(winningNumbersInput);

        String bonusNumberInput = viewFacade.getBonusNumber();
        int bonusNumber = Parser.parseToInt(bonusNumberInput);

        WinningStatistic winningStatistic = lottoFacade.getStatistic(purchaseAmount, cost, winningNumbers,
                bonusNumber, lottos);

        viewFacade.showWinningStatistics(winningStatistic);
    }
}
