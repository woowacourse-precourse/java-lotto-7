package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void 당첨등수_정상적용_테스트() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE);
    }

    @Test
    void 당첨금액_포맷_테스트() {
        assertThat(Rank.FIRST.getFormattedPrize()).isEqualTo("2,000,000,000원");
        assertThat(Rank.SECOND.getFormattedPrize()).isEqualTo("30,000,000원");
        assertThat(Rank.THIRD.getFormattedPrize()).isEqualTo("1,500,000원");
        assertThat(Rank.FOURTH.getFormattedPrize()).isEqualTo("50,000원");
        assertThat(Rank.FIFTH.getFormattedPrize()).isEqualTo("5,000원");
    }
}
