package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseValidator;
import lotto.validator.WinningNumberValidator;
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
        int purchaseAmountInt = requestAndValidatePurchaseAmount();
        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmountInt);

        OutputView.printPurchaseMessage(lottoTicket.getLottos().size());
        OutputView.printLottos(lottoTicket);

        List<Integer> winningNumbersInteger = requestAndValidateWinningNumbers();
        int bonusNumber = requestAndValidateBonusNumber(winningNumbersInteger);

        Map<LottoResult, Integer> lottoResultCount = calculateStatistics(lottoTicket, winningNumbersInteger,
                bonusNumber);
        displayStatistics(lottoResultCount, purchaseAmountInt);
    }

    private int requestAndValidatePurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = InputView.requestPurchaseAmount();
                return PurchaseValidator.validatePurchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> requestAndValidateWinningNumbers() {
        while (true) {
            try {
                List<String> winningNumbersInput = InputView.requestWinningNumbers();
                return WinningNumberValidator.validateWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int requestAndValidateBonusNumber(List<Integer> winningNumbersInteger) {
        while (true) {
            try {
                String bonusNumberInput = InputView.requestBonusNumber();
                return BonusNumberValidator.validateBonusNumber(bonusNumberInput, winningNumbersInteger);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Map<LottoResult, Integer> calculateStatistics(LottoTicket lottoTicket, List<Integer> winningNumbersInteger,
                                                          int bonusNumber) {
        return lottoService.calculateStatisticsLottoResult(lottoTicket, winningNumbersInteger, bonusNumber);
    }

    private void displayStatistics(Map<LottoResult, Integer> lottoResultCount, int purchaseAmountInt) {
        OutputView.printWinningStatistics(lottoResultCount);

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmountInt);
        OutputView.printRateEarning(rateEarning);
    }
}
