package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        OutputView.printInputPurchaseMoneyMessage();
        String money = InputView.getUserInput();
        int purchaseMoney = lottoService.getPurchaseMoney(money);
        int lottoCount = lottoService.getLottoCount(purchaseMoney);

        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        OutputView.printLottoCountMessage(lottoCount);
        OutputView.printLottoNumbers(lottos);

        OutputView.printInputWinningNumbers();
        String winningNumbersInput = InputView.getUserInput();
        Lotto winningLotto = lottoService.getWinningLotto(winningNumbersInput);

        OutputView.printInputBonusNumber();
        String bonusNumberInput = InputView.getUserInput();
        int bonusNumber = lottoService.getBonusNumber(bonusNumberInput);

        Map<String, Integer> matchCounts = lottoService.getMatchCounts(lottos, winningLotto, bonusNumber);
        OutputView.printPrizeStatistics(matchCounts);

        long totalPrizeMoney = lottoService.getPrizeMoney(matchCounts);
        String rateOfReturn = lottoService.getRateOfReturn(totalPrizeMoney, purchaseMoney);
        OutputView.printRateOfReturn(rateOfReturn);

    }
}
