package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoResultCalculator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;
import lotto.validation.LottoInputValidator;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoResultCalculator resultCalculator;

    public LottoService(LottoGenerator lottoGenerator, LottoResultCalculator resultCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.resultCalculator = resultCalculator;
    }

    public int validateAndParsePurchaseAmount(String purchaseAmountInput) {
        String validationError = LottoInputValidator.validatePurchaseAmount(purchaseAmountInput);
        if (validationError != null) {
            throw new IllegalArgumentException(validationError);
        }
        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Lotto> generateLottos(int purchaseAmount) {
        return lottoGenerator.generateLottos(purchaseAmount);
    }

    public List<Integer> validateAndParseWinningNumbers(String winningNumbersInput) {
        return LottoInputValidator.validateWinningNumbers(winningNumbersInput);
    }

    public int validateAndParseBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        return LottoInputValidator.validateBonusNumber(bonusNumberInput, winningNumbers);
    }

    public Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return resultCalculator.calculateStatistics(lottos, winningNumbers, bonusNumber);
    }

    public double calculateROI(Map<Rank, Integer> statistics, int purchaseAmount) {
        return resultCalculator.calculateROI(statistics, purchaseAmount);
    }
}
