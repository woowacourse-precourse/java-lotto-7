package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "5000, 62.5",
            "50000, 625.0",
            "1500000, 18750.0",
            "30000000, 375000.0",
            "2000000000, 25000000.0"
    })
    @DisplayName("당첨 금액과 구입 금액으로 총 수익률을 구한다.")
    void calculateProfitRate(int condition, String expectedRate) {
        final int purchaseAmount = 8000;
        double profitRate = ((double) condition / purchaseAmount) * 100;
        String formattedProfitRate = String.format("%.1f", profitRate);

        assertThat(formattedProfitRate).isEqualTo(expectedRate);
    }

    @ParameterizedTest
    @CsvSource({
            "'8,9,10,11,12,13', 0.0",
            "'1,2,3,8,9,10', 500.0",
            "'1,2,3,4,8,9', 5000.0",
            "'1,2,3,4,5,8', 150000.0",
            "'1,2,3,4,5,7', 3000000.0",
            "'1,2,3,4,5,6', 200000000.0"
    })
    @DisplayName("각 로또 당첨 조건에 따른 총 수익률을 검증한다.")
    void profitRateCalculationForEachRank(String lottoStr, String expectedRate) {
        List<Integer> lotto = Arrays.stream(lottoStr.split(","))
                .map(Integer::parseInt)
                .toList();

        // given
        List<Lotto> lottos = List.of(Lotto.from(lotto));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        final int purchaseAmount = 1000;

        // then
        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers, bonusNumber);
        List<LottoRankType> ranks = lottoResult.getLottoRankTypes();
        String result = LottoProfitCalculator.from(ranks, purchaseAmount).getLottoProfitRate();

        // then
        assertThat(result).isEqualTo(expectedRate);
    }

}