package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {
    @DisplayName("당첨금이 일치한다.")
    @Test
    void 당첨금이_일치한다() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.NONE.getPrize()).isZero();
    }

    @DisplayName("당첨 설명을 확인한다.")
    @Test
    void 당첨_설명을_확인한다() {
        assertThat(Rank.FIRST.getDescription()).contains("6개");
        assertThat(Rank.SECOND.getDescription()).contains("5개", "보너스");
        assertThat(Rank.THIRD.getDescription()).contains("5개");
        assertThat(Rank.FOURTH.getDescription()).contains("4개");
        assertThat(Rank.FIFTH.getDescription()).contains("3개");
    }
}
