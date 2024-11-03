package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final int EXPECTED_FIRST_COUNT = 2;
    private static final int EXPECTED_SECOND_COUNT = 1;
    private static final int EXPECTED_THIRD_COUNT = 0;
    private static final int PURCHASE_AMOUNT = 10_000;
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("초기 상태에서 등수별 개수가 모두 0으로 초기화 여부 확인")
    @Test
    void 초기_LottoResult_생성_테스트() {
        Map<Rank, Integer> winningResults = lottoResult.getWinningResults();
        for (Rank rank : Rank.values()) {
            assertThat(winningResults.get(rank)).isZero();
        }
    }

    @DisplayName("당첨 결과 등수 추가 기능이 정상적으로 동작하는지 테스트")
    @Test
    void 당첨_결과_등수_추가_테스트() {
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.SECOND);
        lottoResult.addResult(Rank.FIRST);
        Map<Rank, Integer> winningResults = lottoResult.getWinningResults();

        assertThat(winningResults).containsEntry(Rank.FIRST, EXPECTED_FIRST_COUNT)
                .containsEntry(Rank.SECOND, EXPECTED_SECOND_COUNT)
                .containsEntry(Rank.THIRD, EXPECTED_THIRD_COUNT);
    }

    @DisplayName("수익률 계산 기능이 정상적으로 동작하는지 테스트")
    @Test
    void 수익률_계산_테스트() {
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.FIFTH);

        double returnOnInvestment = lottoResult.calculateReturnOnInvestment(PURCHASE_AMOUNT);
        double expectedReturnOnInvestment = ((double) (Rank.FIRST.getPrizeMoney() + Rank.FIFTH.getPrizeMoney()) / PURCHASE_AMOUNT) * PERCENTAGE_CONVERSION_FACTOR;

        assertThat(returnOnInvestment).isEqualTo(expectedReturnOnInvestment);
    }
}
