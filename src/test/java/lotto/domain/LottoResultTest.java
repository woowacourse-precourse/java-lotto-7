package lotto.domain;

import lotto.TestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final double EXPECTED_RETURN_ON_INVESTMENT = 62.5;

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
        Map<Rank, Integer> winningResults = lottoResult.getWinningResults();

        assertThat(winningResults).containsEntry(Rank.FIRST, TestConstants.EXPECTED_FIRST_COUNT)
                .containsEntry(Rank.SECOND, TestConstants.EXPECTED_SECOND_COUNT)
                .containsEntry(Rank.THIRD, TestConstants.EXPECTED_THIRD_COUNT)
                .containsEntry(Rank.FOURTH, TestConstants.EXPECTED_FOURTH_COUNT)
                .containsEntry(Rank.FIFTH, TestConstants.EXPECTED_FIFTH_COUNT)
                .containsEntry(Rank.NONE, TestConstants.EXPECTED_NONE_COUNT);
    }

    @DisplayName("수익률 계산 기능이 정상적으로 동작하는지 테스트")
    @Test
    void 수익률_계산_테스트() {
        lottoResult.addResult(Rank.FIFTH);
        lottoResult.calculateReturnOnInvestment(TestConstants.VALID_PURCHASE_AMOUNT);

        assertThat(lottoResult.getReturnOnInvestment()).isEqualTo(EXPECTED_RETURN_ON_INVESTMENT);
    }
}
