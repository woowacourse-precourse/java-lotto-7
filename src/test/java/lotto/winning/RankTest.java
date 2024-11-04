package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 등수_확인_테스트_3등() {
        Rank rank = Rank.getWinningRank(5,false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 등수_확인_테스트_2등() {
        Rank rank = Rank.getWinningRank(5,true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 등수_확인_테스트_꽝() {
        Rank rank = Rank.getWinningRank(2,false);
        assertThat(rank).isEqualTo(Rank.LOSING_TICKET);
    }

    @Test
    void 등수_확인_테스트_예외값_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> Rank.getWinningRank(2,true));
    }

    @Test
    @DisplayName("등수별 총 수익 반환 테스트")
    void 등수별_총_수익_반환_테스트() {
        long profit = Rank.FIRST.getProfit(5);
        assertThat(profit).isEqualTo(10_000_000_000L);
    }

    @Test
    @DisplayName("1등 총 수익 최대값 반환 테스트")
    void 총_수익_1등_최대값_반환_테스트() {
        long profit = Rank.FIRST.getProfit(Integer.MAX_VALUE);
        assertThat(profit).isEqualTo(Integer.MAX_VALUE * 2_000_000_000L);
    }

    @Test
    @DisplayName("통계 메시지 반환 테스트")
    void 통계_메시지_반환_테스트() {
        String message = Rank.FIRST.getMessage(10);
        assertThat(message).contains(
                "6개 일치 (2,000,000,000원) - 10개"
        );
    }

}