package lotto.controller;

import java.util.List;
import lotto.factory.LottoFactory;
import lotto.factory.WinningNumbersFactory;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
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
        List<Integer> numbers = Parser.parseWinningNumbers(winningNumbersInput);

        Lotto winningLotto = LottoFactory.creatLotto(numbers);
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(winningLotto);

        String bonusNumberInput = viewFacade.getBonusNumber();
        int bonusNumber = Parser.parseToInt(bonusNumberInput);

        winningNumbers = winningNumbers.createWithBonusNumber(winningNumbers, bonusNumber);

        WinningStatistic winningStatistic = lottoFacade.getStatistic(cost, lottos, winningNumbers);

        viewFacade.showWinningStatistics(winningStatistic);
    }
}
