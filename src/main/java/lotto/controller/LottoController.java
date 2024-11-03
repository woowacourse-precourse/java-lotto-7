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
        int purchaseAmountInt = 0;
        while (true) {
            try {
                String purchaseAmount = InputView.requestPurchaseAmount();
                purchaseAmountInt = InputValidator.validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmountInt);
        OutputView.printPurchaseMessage(lottoTicket.getLottos().size());
        OutputView.printLottos(lottoTicket);

        List<Integer> winningNumbersInteger = null;
        while (true) {
            try {
                List<String> winningNumbersInput = InputView.requestWinningNumbers();
                winningNumbersInteger = InputValidator.validateWinningNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        int bonusNumber = 0;
        while (true) {
            try {
                String bonusNumberInput = InputView.requestBonusNumber();
                bonusNumber = InputValidator.validateBonusNumber(bonusNumberInput, winningNumbersInteger);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        Map<LottoResult, Integer> lottoResultCount = lottoService.calculateStatisticsLottoResult(
                lottoTicket, winningNumbersInteger, bonusNumber);
        OutputView.printWinningStatistics(lottoResultCount);

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmountInt);
        OutputView.printRateEarning(rateEarning);
    }

}
