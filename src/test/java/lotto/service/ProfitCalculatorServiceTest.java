package lotto.service;

import lotto.constant.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ProfitCalculatorServiceTest {
    private ProfitCalculatorService profitCalculator;

    @BeforeEach
    void setUp() {
        profitCalculator = ProfitCalculatorService.getInstance();
    }

    @DisplayName("당첨금 총액 계산")
    @Test
    void calculateWinningAmount_테스트() {
        // given
        Map<Rank, Integer> prizeResults = new HashMap<>();
        prizeResults.put(Rank.FIRST, 1);    // 2,000,000,000
        prizeResults.put(Rank.THIRD, 1);    // 1,500,000
        prizeResults.put(Rank.FIFTH, 2);    // 5,000 * 2

        // when
        Long totalPrize = profitCalculator.calculateWinningAmount(prizeResults);

        // then
        Assertions.assertThat(totalPrize).isEqualTo(2_001_510_000L);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateBenefitRate_테스트() {
        // given
        int purchasePrice = 8000;        // 8,000원 구매
        Long totalPrize = 5000L;         // 5,000원 당첨

        // when
        Double benefitRate = profitCalculator.calculateBenefitRate(purchasePrice, totalPrize);

        // then
        Assertions.assertThat(benefitRate).isEqualTo(62.5);
    }

    @DisplayName("수익률 계산 - 소수점 첫째자리까지 반올림")
    @Test
    void calculateBenefitRate_반올림_테스트() {
        // given
        int purchasePrice = 1000;
        Long totalPrize = 1234L;

        // when
        Double benefitRate = profitCalculator.calculateBenefitRate(purchasePrice, totalPrize);

        // then
        Assertions.assertThat(benefitRate).isEqualTo(123.4);
    }

    @DisplayName("당첨 결과가 없는 경우 당첨금 총액은 0")
    @Test
    void calculateWinningAmount_빈_결과_테스트() {
        // given
        Map<Rank, Integer> emptyResults = new HashMap<>();

        // when
        Long totalPrize = profitCalculator.calculateWinningAmount(emptyResults);

        // then
        Assertions.assertThat(totalPrize).isEqualTo(0L);
    }

}
