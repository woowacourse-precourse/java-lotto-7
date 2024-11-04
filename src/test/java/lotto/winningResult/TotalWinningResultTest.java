package lotto.winningResult;

import static lotto.lotto.MatchingCondition.FAILURE;
import static lotto.lotto.MatchingCondition.FIVE;
import static lotto.lotto.MatchingCondition.FIVE_AND_BONUS;
import static lotto.lotto.MatchingCondition.FOUR;
import static lotto.lotto.MatchingCondition.SIX;
import static lotto.lotto.MatchingCondition.THREE;
import static lotto.winningResult.WinningResultInfo.FAILURE_RANK;
import static lotto.winningResult.WinningResultInfo.FIFTH_RANK;
import static lotto.winningResult.WinningResultInfo.FIRST_RANK;
import static lotto.winningResult.WinningResultInfo.FOURTH_RANK;
import static lotto.winningResult.WinningResultInfo.SECOND_RANK;
import static lotto.winningResult.WinningResultInfo.THIRD_RANK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.Map;
import lotto.lotto.MatchingCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalWinningResultTest {

    @Test
    @DisplayName("분류된 당첨 결과를 당첨 금액 정보로 변환한다")
    void changeMatchingInfoToWinningResult() {
        // given
        List<MatchingCondition> conditions = List.of(SIX, FIVE_AND_BONUS, FIVE, FOUR, THREE, FAILURE);

        // when then
        assertDoesNotThrow(() -> TotalWinningResult.from(conditions));
    }

    @Test
    @DisplayName("당첨된 로또들을 등수별 당첨 갯수로 정리한다")
    void changeWinningResultToStatistics() {
        // given
        List<MatchingCondition> conditions = List.of(SIX, FIVE_AND_BONUS, FIVE, FOUR, THREE, FAILURE);
        TotalWinningResult totalWinningResult = TotalWinningResult.from(conditions);

        // when
        Map<WinningResultInfo, Long> winningResultStatistics = totalWinningResult.getWinningResultMap();

        // then
        assertThat(winningResultStatistics).contains(
                entry(FIRST_RANK, 1L), entry(SECOND_RANK, 1L), entry(THIRD_RANK, 1L), entry(FOURTH_RANK, 1L),
                entry(FIFTH_RANK, 1L), entry(FAILURE_RANK, 1L));
    }
}
