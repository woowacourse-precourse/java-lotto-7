package lotto.service;

import java.util.List;
import lotto.common.IntegerParser;
import lotto.common.RandomNumberGenerator;
import lotto.domain.IssuedLotto;
import lotto.domain.IssuedRandomLotto;
import lotto.domain.LottoProfitCalculator;
import lotto.domain.LottoResult;
import lotto.domain.validator.LottoResultValidator;
import lotto.domain.validator.LottoValidator;
import lotto.dto.LottoStatisticsDto;

public class LottoService {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public IssuedRandomLotto createIssuedRandomLotto(int purchaseAmount) {
        IssuedRandomLotto issuedLotto = new IssuedRandomLotto(randomNumberGenerator, purchaseAmount);
        issuedLotto.generateIssuedLottos();
        return issuedLotto;
    }

    public LottoResult createLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(winningNumbers, bonusNumber);
    }

    public LottoStatisticsDto calculateLottoStatistics(LottoResult lottoResult, IssuedLotto issuedLotto) {
        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        calculator.calculateLottoStatistics();
        double lottoRateOfProfit = calculator.calculateRateOfProfit();

        return LottoStatisticsDto.of(calculator.getLottoRanks(), lottoRateOfProfit);
    }

    public List<Integer> parseAndValidateWinningNumbers(List<String> inputWinningNumbers) {
        List<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(winningNumber -> IntegerParser.parseToInt(winningNumber))
                .toList();
        LottoValidator.validate(winningNumbers);
        return winningNumbers;
    }

    public int parseAndValidateBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        int bonusNumber = IntegerParser.parseToInt(inputBonusNumber);
        LottoResultValidator.bonusNumberValidate(bonusNumber, winningNumbers);
        return bonusNumber;
    }
}
