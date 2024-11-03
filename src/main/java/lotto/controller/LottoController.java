package lotto.controller;

import static lotto.view.OutputView.printStatisticsHeader;

import java.math.BigDecimal;
import lotto.domain.Receipt;
import lotto.dto.LottoResult;
import lotto.dto.RankCount;
import lotto.dto.RankCounts;
import lotto.exception.InputException;
import lotto.service.LottoService;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputValidator inputValidator;

    public LottoController(LottoService lottoService, InputValidator inputValidator) {
        this.lottoService = lottoService;
        this.inputValidator = inputValidator;
    }

    public void startLottoGame() {
        Receipt receipt = purchaseLottos();
        LottoResult lottoResult = getLottoResult(receipt);
        displayLottoResults(lottoResult);
    }

    private Receipt purchaseLottos() {
        String purchaseAmount = getPurchaseLottos();
        OutputView.printPurchaseAmount(purchaseAmount);
        return lottoService.generateLottos(purchaseAmount);
    }

    private LottoResult getLottoResult(Receipt receipt) {
        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber(winningNumbers);
        return lottoService.calculateLottoResult(receipt, winningNumbers, bonusNumber);
    }

    private String getPurchaseLottos() {
        while (true) {
            try {
                String purchaseAmount = InputView.inputPurchaseAmount();
                inputValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (InputException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = InputView.inputWinningNumbers();
                inputValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (InputException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String getBonusNumber(String winningNumbers) {
        while (true) {
            try {
                String bonusNumber = InputView.inputBonusNumber();
                inputValidator.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (InputException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayLottoResults(LottoResult lottoResult) {
        printStatisticsHeader();
        RankCounts rankCounts = lottoResult.getRankCounts();
        for (RankCount rankCount : rankCounts.getRankCounts()) {
            OutputView.printResultStatistics(rankCount);
        }
        BigDecimal profitRate = lottoService.calculateProfitRate(lottoResult);
        OutputView.printProfitRate(profitRate);
    }
}
