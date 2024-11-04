package lotto.model.result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @Nested
    @DisplayName("from 메서드 테스트")
    class FromMethodTests {

        @Test
        @DisplayName("6개 일치 시 FIRST 등수를 반환한다")
        void whenSixMatches_thenReturnFirst() {
            WinningRank rank = WinningRank.from(6, false);
            assertThat(rank).isEqualTo(WinningRank.FIRST);
        }

        @Test
        @DisplayName("5개 일치와 보너스 번호 일치 시 SECOND 등수를 반환한다")
        void whenFiveMatchesWithBonus_thenReturnSecond() {
            WinningRank rank = WinningRank.from(5, true);
            assertThat(rank).isEqualTo(WinningRank.SECOND);
        }

        @Test
        @DisplayName("5개 일치 시 THIRD 등수를 반환한다")
        void whenFiveMatchesWithoutBonus_thenReturnThird() {
            WinningRank rank = WinningRank.from(5, false);
            assertThat(rank).isEqualTo(WinningRank.THIRD);
        }

        @Test
        @DisplayName("4개 일치 시 FOURTH 등수를 반환한다")
        void whenFourMatches_thenReturnFourth() {
            WinningRank rankWithBonus = WinningRank.from(4, true);
            WinningRank rankWithoutBonus = WinningRank.from(4, false);

            assertThat(rankWithBonus).isEqualTo(WinningRank.FOURTH);
            assertThat(rankWithoutBonus).isEqualTo(WinningRank.FOURTH);
        }

        @Test
        @DisplayName("3개 일치 시 FIFTH 등수를 반환한다")
        void whenThreeMatches_thenReturnFifth() {
            WinningRank rankWithBonus = WinningRank.from(3, true);
            WinningRank rankWithoutBonus = WinningRank.from(3, false);

            assertThat(rankWithBonus).isEqualTo(WinningRank.FIFTH);
            assertThat(rankWithoutBonus).isEqualTo(WinningRank.FIFTH);
        }

        @Test
        @DisplayName("2개 이하 일치 시 NONE을 반환한다")
        void whenLessThanThreeMatches_thenReturnNone() {
            WinningRank rankOneMatch = WinningRank.from(1, false);
            WinningRank rankTwoMatches = WinningRank.from(2, false);

            assertThat(rankOneMatch).isEqualTo(WinningRank.NONE);
            assertThat(rankTwoMatches).isEqualTo(WinningRank.NONE);
        }
    }

    @Nested
    @DisplayName("getter 메서드 테스트")
    class GetterMethodTests {

        @Test
        @DisplayName("FIRST 등수의 상금을 반환한다")
        void getCashPrizeForFirst() {
            assertThat(WinningRank.FIRST.getCashPrize()).isEqualTo(2_000_000_000);
        }

        @Test
        @DisplayName("SECOND 등수의 설명을 반환한다")
        void getDisplayForSecond() {
            assertThat(WinningRank.SECOND.getDisplay()).isEqualTo("5개 일치, 보너스 볼 일치");
        }
    }
}