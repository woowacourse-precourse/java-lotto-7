package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final StatisticsService statisticsService;

    public LottoController(LottoService lottoService, StatisticsService statisticsService) {
        this.lottoService = lottoService;
        this.statisticsService = statisticsService;
    }

    public void run() {
        String purchaseAmount = InputView.requestPurchaseAmount();
        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmountInt);
        OutputView.printPurchaseMessage(lottoTicket.getLottos().size());
        OutputView.printLottos(lottoTicket);

        List<Integer> winningNumbersInteger = InputView.requestWinningNumbers();
        int bonusNumber = InputView.requestBonusNumber();

        Map<LottoResult, Integer> lottoResultCount = lottoService.calculateStatisticsLottoResult(lottoTicket,
                winningNumbersInteger,
                bonusNumber);
        OutputView.printWinningStatistics(lottoResultCount);

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmountInt);
        OutputView.printRateEarning(rateEarning);
    }

    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야합니다");
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야합니다.");
        }

        return purchaseAmountInt;
    }
}
