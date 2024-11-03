package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsTest {

    @Nested
    @DisplayName("WinningStatistics 초기화")
    class WinningStatisticsInitializationTests {

        @DisplayName("초기화 시 모든 WinningRule의 개수는 0이어야 한다.")
        @Test
        void winningStatistics_초기화() {
            WinningStatistics statistics = new WinningStatistics();

            for (WinningRule rule : WinningRule.values()) {
                assertEquals(0, statistics.getStatisticResultByRule(rule));
            }
        }
    }

    @Nested
    @DisplayName("WinningStatistics 증가 기능")
    class WinningStatisticsIncrementTests {

        @DisplayName("WinningRule을 증가시킬 수 있어야 한다.")
        @Test
        void winningStatistics_증가() {
            WinningStatistics statistics = new WinningStatistics();
            statistics.increment(WinningRule.FIFTH_PRIZE);

            assertEquals(1, statistics.getStatisticResultByRule(WinningRule.FIFTH_PRIZE));
        }

        @DisplayName("WinningRule이 null인 경우 예외 발생")
        @Test
        void winningStatistics_예외_루트가_null() {
            WinningStatistics statistics = new WinningStatistics();

            assertThatThrownBy(() -> statistics.increment(null))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.WINNING_RULE_NULL.getMessage());
        }
    }
}

