package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("Rank 열거형의 각 등수가 올바른 라벨과 당첨 금액을 가져야 한다.")
    void Rank_열거형의_각_등수가_올바른_라벨과_당첨_금액을_가져야_한다() {
        assertThat(Rank.FIRST.getLabel()).isEqualTo("1등");
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000L);

        assertThat(Rank.SECOND.getLabel()).isEqualTo("2등");
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000L);

        assertThat(Rank.THIRD.getLabel()).isEqualTo("3등");
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000L);

        assertThat(Rank.FOURTH.getLabel()).isEqualTo("4등");
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000L);

        assertThat(Rank.FIFTH.getLabel()).isEqualTo("5등");
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000L);
    }
}
