package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.WinningLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCalculatorTest {

    private LottoResult createRankCounts(LottoResultCalculator calculator, Lottos lottos,
                                         WinningLottoNumbers winningLottoNumbers,
                                         int purchaseAmount) {
        return calculator.calculateResult(lottos, winningLottoNumbers, purchaseAmount);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 모든 로또가 5등인 경우")
    public void 낮은_수익률을_계산해야한다() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 11, 12, 13),
                Arrays.asList(1, 2, 3, 11, 12, 14)
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        Lottos lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 2000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoResult lottoResult = createRankCounts(calculator, lottos, winningLottoNumbers, purchaseAmount);

        BigDecimal expectedTotalPrize = new BigDecimal(10000);
        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        BigDecimal profitRate = calculator.calculateProfitRate(lottoResult);

        assertEquals(expectedProfitRate, profitRate);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 다양한 등수 조합")
    public void 다양한_등수의_수익률을_계산해야한다() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 7),   // 2등
                Arrays.asList(1, 2, 3, 4, 5, 8),   // 3등
                Arrays.asList(1, 2, 3, 4, 9, 10),  // 4등
                Arrays.asList(1, 2, 3, 11, 12, 13) // 5등
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        Lottos lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 4000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoResult lottoResult = createRankCounts(calculator, lottos, winningLottoNumbers, purchaseAmount);

        BigDecimal expectedTotalPrize = new BigDecimal(30000000)
                .add(new BigDecimal(1500000))
                .add(new BigDecimal(50000))
                .add(new BigDecimal(5000));

        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        BigDecimal profitRate = calculator.calculateProfitRate(lottoResult);

        assertEquals(expectedProfitRate, profitRate);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 모든 로또가 1등인 경우")
    public void 매우높은_수익률을_계산해야한다() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        Lottos lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 2000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoResult lottoResult = createRankCounts(calculator, lottos, winningLottoNumbers, purchaseAmount);

        BigDecimal expectedTotalPrize = new BigDecimal(2000000000).multiply(new BigDecimal(2));
        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        BigDecimal profitRate = calculator.calculateProfitRate(lottoResult);

        assertEquals(expectedProfitRate, profitRate);
    }
}
