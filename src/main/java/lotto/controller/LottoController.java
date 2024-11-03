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
        String Money = InputView.getUserInput();
        int purchaseMoney = Integer.parseInt(Money);
        int lottoCount = purchaseMoney / 1000;

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
