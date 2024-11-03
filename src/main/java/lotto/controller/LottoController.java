package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.validator.InputValidator;
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
        int purchaseAmountInt = InputValidator.validatePurchaseAmount(purchaseAmount);

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmountInt);
        OutputView.printPurchaseMessage(lottoTicket.getLottos().size());
        OutputView.printLottos(lottoTicket);

        List<String> winningNumbersInput = InputView.requestWinningNumbers();
        List<Integer> winningNumbersInteger = InputValidator.validateWinningNumbers(winningNumbersInput);

        String bonusNumberInput = InputView.requestBonusNumber();
        int bonusNumber = InputValidator.validateBonusNumber(bonusNumberInput, winningNumbersInteger);

        Map<LottoResult, Integer> lottoResultCount = lottoService.calculateStatisticsLottoResult(
                lottoTicket, winningNumbersInteger, bonusNumber);
        OutputView.printWinningStatistics(lottoResultCount);

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmountInt);
        OutputView.printRateEarning(rateEarning);
    }

}
