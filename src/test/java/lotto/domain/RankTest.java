package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("각 Rank에 해당하는 matchCount와 isBonusMatch를 입력하면 해당 Rank를 반환한다.")
    void RankValueOfTest() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("각 Rank에 해당하는 상금을 반환한다.")
    void getPrizeTest() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.NONE.getPrize()).isEqualTo(0);
    }

    @Test
    @DisplayName("각 Rank에 해당하는 상금을 포맷팅하여 반환한다.")
    void getFormattedPrizeTest() {
        assertThat(Rank.FIRST.getFormattedPrize()).isEqualTo(" (2,000,000,000원)");
        assertThat(Rank.SECOND.getFormattedPrize()).isEqualTo(" (30,000,000원)");
        assertThat(Rank.THIRD.getFormattedPrize()).isEqualTo(" (1,500,000원)");
        assertThat(Rank.FOURTH.getFormattedPrize()).isEqualTo(" (50,000원)");
        assertThat(Rank.FIFTH.getFormattedPrize()).isEqualTo(" (5,000원)");
        assertThat(Rank.NONE.getFormattedPrize()).isEqualTo(" (0원)");
    }

    @Test
    @DisplayName("각 Rank에 해당하는 메시지를 반환한다.")
    void getMessageTest() {
        assertThat(Rank.FIRST.getMessage()).isEqualTo("6개 일치");
        assertThat(Rank.SECOND.getMessage()).isEqualTo("5개 일치, 보너스 볼 일치");
        assertThat(Rank.THIRD.getMessage()).isEqualTo("5개 일치");
        assertThat(Rank.FOURTH.getMessage()).isEqualTo("4개 일치");
        assertThat(Rank.FIFTH.getMessage()).isEqualTo("3개 일치");
        assertThat(Rank.NONE.getMessage()).isEqualTo("0개 일치");
    }

    @Test
    @DisplayName("Rank에 해당하는 matchCount와 isBonusMatch가 일치 하는지 확인한다.")
    void RankValueOfMatchCountAndIsBonusMatchTest() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.NONE);
    }
}