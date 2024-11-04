package lotto.handler;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainLogicHandler {
    private final LottoService lottoService;
    int purchaseMoney, lottoCount, bonusNumber;
    Lotto winningLotto;
    List<Lotto> lottos;
    Map<String, Integer> matchCounts;
    String rateOfReturn;

    public MainLogicHandler() {
        this.lottoService = new LottoService();
    }

    public void handlePurchaseMoney() {
        try {
            String money = InputView.getUserInput();
            purchaseMoney = lottoService.getPurchaseMoney(money);
            lottoCount = lottoService.getLottoCount(purchaseMoney);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handlePurchaseMoney();
        }
    }

    public void handleLottos() {
        lottos = lottoService.generateLottos(lottoCount);
        OutputView.printLottoCountMessage(lottoCount);
        OutputView.printLottoNumbers(lottos);
    }

    public void handleWinningLotto() {
        try {
            String winningNumbersInput = InputView.getUserInput();
            winningLotto = lottoService.getWinningLotto(winningNumbersInput);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleWinningLotto();
        }
    }

    public void handleBonusNumber() {
        try {
            String bonusNumberInput = InputView.getUserInput();
            bonusNumber = lottoService.getBonusNumber(bonusNumberInput, winningLotto.getNumbers());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleBonusNumber();
        }
    }

    public void handleMatchCounts() {
        matchCounts = lottoService.getMatchCounts(lottos, winningLotto, bonusNumber);
        OutputView.printPrizeStatistics(matchCounts);
    }

    public void handleRateOfReturn() {
        long totalPrizeMoney = lottoService.getPrizeMoney(matchCounts);
        rateOfReturn = lottoService.getRateOfReturn(totalPrizeMoney, purchaseMoney);
    }

    public String getRateOfReturn() {
        return rateOfReturn;
    }
}
