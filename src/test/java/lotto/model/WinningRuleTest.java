package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WinningRuleTest {

    @Nested
    @DisplayName("WinningRule 유효성 검사")
    class WinningRuleValidationTests {

        @DisplayName("일치 개수가 음수일 경우 예외 발생")
        @Test
        void winningRule_일치개수_음수() {
            assertThatThrownBy(() -> WinningRule.of(-1, false))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.MATCH_COUNT_NEGATIVE.getMessage());
        }

        @DisplayName("6개 일치 시 FIRST_PRIZE 반환")
        @Test
        void winningRule_6개일치() {
            WinningRule result = WinningRule.of(6, false);
            assertEquals(WinningRule.FIRST_PRIZE, result);
        }

        @DisplayName("5개 일치, 보너스 볼 일치 시 SECOND_PRIZE 반환")
        @Test
        void winningRule_5개일치_보너스일치() {
            WinningRule result = WinningRule.of(5, true);
            assertEquals(WinningRule.SECOND_PRIZE, result);
        }

        @DisplayName("5개 일치 시 THIRD_PRIZE 반환")
        @Test
        void winningRule_5개일치() {
            WinningRule result = WinningRule.of(5, false);
            assertEquals(WinningRule.THIRD_PRIZE, result);
        }

        @DisplayName("4개 일치 시 FOURTH_PRIZE 반환")
        @Test
        void winningRule_4개일치() {
            WinningRule result = WinningRule.of(4, false);
            assertEquals(WinningRule.FOURTH_PRIZE, result);
        }

        @DisplayName("3개 일치 시 FIFTH_PRIZE 반환")
        @Test
        void winningRule_3개일치() {
            WinningRule result = WinningRule.of(3, false);
            assertEquals(WinningRule.FIFTH_PRIZE, result);
        }

        @DisplayName("일치 개수가 0일 경우 NOT_MATCHED 반환")
        @Test
        void winningRule_0개일치() {
            WinningRule result = WinningRule.of(0, false);
            assertEquals(WinningRule.NOT_MATCHED, result);
        }
    }

    @Nested
    @DisplayName("WinningRule의 속성 검사")
    class WinningRulePropertiesTests {

        @DisplayName("FIRST_PRIZE의 설명과 상금 확인")
        @Test
        void winningRule_FIRST_PRIZE_속성() {
            assertEquals("6개 일치 (2,000,000,000원)", WinningRule.FIRST_PRIZE.getDescription());
            assertEquals(2_000_000_000, WinningRule.FIRST_PRIZE.getPrizeAmount());
        }

        @DisplayName("NOT_MATCHED의 winning 체크")
        @Test
        void winningRule_NOT_MATCHED_확인() {
            assertFalse(WinningRule.NOT_MATCHED.isWinning());
        }
    }
}
