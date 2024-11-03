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
        int purchaseMoney, lottoCount;
        while (true) {
            try {
                String money = InputView.getUserInput();
                purchaseMoney = lottoService.getPurchaseMoney(money);
                lottoCount = lottoService.getLottoCount(purchaseMoney);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        OutputView.printLottoCountMessage(lottoCount);
        OutputView.printLottoNumbers(lottos);

        OutputView.printInputWinningNumbers();
        Lotto winningLotto;
        while (true) {
            try {
                String winningNumbersInput = InputView.getUserInput();
                winningLotto = lottoService.getWinningLotto(winningNumbersInput);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        OutputView.printInputBonusNumber();
        int bonusNumber;
        while (true) {
            try {
                String bonusNumberInput = InputView.getUserInput();
                bonusNumber = lottoService.getBonusNumber(bonusNumberInput, winningLotto.getNumbers());
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Map<String, Integer> matchCounts = lottoService.getMatchCounts(lottos, winningLotto, bonusNumber);
        OutputView.printPrizeStatistics(matchCounts);

        long totalPrizeMoney = lottoService.getPrizeMoney(matchCounts);
        String rateOfReturn = lottoService.getRateOfReturn(totalPrizeMoney, purchaseMoney);
        OutputView.printRateOfReturn(rateOfReturn);

    }
}
