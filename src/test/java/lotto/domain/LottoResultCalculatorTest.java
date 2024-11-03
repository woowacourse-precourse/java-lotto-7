package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCalculatorTest {

    @Test
    @DisplayName("수익률 계산 테스트 - 모든 로또가 당첨되지 않은 경우")
    public void 수익률을_0퍼센트로_계산해야한다() {
        // given
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        // 당첨되지 않는 로또 번호들
        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(10, 11, 12, 13, 14, 15),
                Arrays.asList(20, 21, 22, 23, 24, 25)
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        List<Lotto> lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 2000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        // when
        BigDecimal profitRate = calculator.calculateProfitRate(lottos, lottoWinningNumbers, purchaseAmount);

        // then - 기대 수익률은 0%
        BigDecimal expectedProfitRate = BigDecimal.ZERO.setScale(1, RoundingMode.HALF_UP);
        assertEquals(expectedProfitRate, profitRate);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 모든 로또가 5등인 경우")
    public void 낮은_수익률을_계산해야한다() {
        // given
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        // 5등 당첨 번호들
        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 11, 12, 13),
                Arrays.asList(1, 2, 3, 11, 12, 14)
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        List<Lotto> lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 2000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        // 예상 총 상금: 5등 5000 * 2 = 10000
        BigDecimal expectedTotalPrize = new BigDecimal(10000);

        // 수익률 계산
        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal profitRate = calculator.calculateProfitRate(lottos, lottoWinningNumbers, purchaseAmount);

        // then
        assertEquals(expectedProfitRate, profitRate);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 다양한 등수 조합")
    public void 다양한_등수의_수익률을_계산해야한다() {
        // given
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 7),   // 2등
                Arrays.asList(1, 2, 3, 4, 5, 8),   // 3등
                Arrays.asList(1, 2, 3, 4, 9, 10),  // 4등
                Arrays.asList(1, 2, 3, 11, 12, 13) // 5등
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        List<Lotto> lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 4000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        // 예상 총 상금: 2등 30000000 + 3등 1500000 + 4등 50000 + 5등 5000 = 31555000
        BigDecimal expectedTotalPrize = new BigDecimal(30000000)
                .add(new BigDecimal(1500000))
                .add(new BigDecimal(50000))
                .add(new BigDecimal(5000));

        // 수익률 계산
        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal profitRate = calculator.calculateProfitRate(lottos, lottoWinningNumbers, purchaseAmount);

        // then
        assertEquals(expectedProfitRate, profitRate);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 모든 로또가 1등인 경우")
    public void 매우높은_수익률을_계산해야한다() {
        // given
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        // 1등 당첨 번호들
        List<List<Integer>> customNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );

        LottoGenerator customGenerator = new CustomLottoGenerator(customNumbers);
        List<Lotto> lottos = customGenerator.generateLottos(customNumbers.size());

        int purchaseAmount = 2000;
        LottoResultCalculator calculator = new LottoResultCalculator();

        // 예상 총 상금: 1등 2000000000 * 2 = 4000000000
        BigDecimal expectedTotalPrize = new BigDecimal(2000000000).multiply(new BigDecimal(2));

        // 수익률 계산
        BigDecimal expectedProfitRate = expectedTotalPrize
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal profitRate = calculator.calculateProfitRate(lottos, lottoWinningNumbers, purchaseAmount);

        // then
        assertEquals(expectedProfitRate, profitRate);
    }
}
