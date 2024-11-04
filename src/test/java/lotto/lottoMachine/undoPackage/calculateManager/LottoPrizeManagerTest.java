package lotto.lottoMachine.undoPackage.calculateManager;

import lotto.lottoMachine.calculateManager.LottoPrizeManager;
import lotto.lottoMachine.utils.LottoResultStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeManagerTest {
    private Map<LottoResultStructure, Integer> results;
    private LottoPrizeManager lottoPrizeManager;

    @BeforeEach
    void setUp() {
        results = new EnumMap<>(LottoResultStructure.class);
    }

    @DisplayName("총 상금이 올바르게 계산되는지 테스트 - 예제 1")
    @Test
    void 총_상금이_올바르게_계산되는지_테스트_예제1() {
        // Given
        results.put(LottoResultStructure.FIFTH, 1);   // 3개 일치: 5,000원
        results.put(LottoResultStructure.FOURTH, 2);  // 4개 일치: 50,000원 x 2
        results.put(LottoResultStructure.THIRD, 1);   // 5개 일치: 1,500,000원
        results.put(LottoResultStructure.SECOND, 1);  // 5개 + 보너스 일치: 30,000,000원
        results.put(LottoResultStructure.FIRST, 0);   // 6개 일치: 없음

        // When
        lottoPrizeManager = new LottoPrizeManager(results);
        long totalPrize = lottoPrizeManager.getTotalPrize();

        // Then
        long expectedTotalPrize = (5_000 * 1) + (50_000 * 2) + (1_500_000 * 1) + (30_000_000 * 1);
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }

    @DisplayName("총 상금이 올바르게 계산되는지 테스트 - 예제 2")
    @Test
    void 총_상금이_올바르게_계산되는지_테스트_예제2() {
        // Given
        results.put(LottoResultStructure.FIFTH, 0);   // 3개 일치: 없음
        results.put(LottoResultStructure.FOURTH, 1);  // 4개 일치: 50,000원
        results.put(LottoResultStructure.THIRD, 0);   // 5개 일치: 없음
        results.put(LottoResultStructure.SECOND, 2);  // 5개 + 보너스 일치: 30,000,000원 x 2
        results.put(LottoResultStructure.FIRST, 1);   // 6개 일치: 2,000,000,000원

        // When
        lottoPrizeManager = new LottoPrizeManager(results);
        long totalPrize = lottoPrizeManager.getTotalPrize();

        // Then
        long expectedTotalPrize = (50_000 * 1) + (30_000_000 * 2) + (2_000_000_000 * 1);
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}
