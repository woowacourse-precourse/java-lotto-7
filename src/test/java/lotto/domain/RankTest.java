package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("Rank 열거형의 각 등수가 올바른 라벨과 당첨 금액을 가져야 한다.")
    void Rank_열거형의_각_등수가_올바른_라벨과_당첨_금액을_가져야_한다() {
        assertThat(Rank.FIRST.getLabel()).isEqualTo("6개 일치");
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000L);

        assertThat(Rank.SECOND.getLabel()).isEqualTo("5개 일치, 보너스 볼 일치");
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000L);

        assertThat(Rank.THIRD.getLabel()).isEqualTo("5개 일치");
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000L);

        assertThat(Rank.FOURTH.getLabel()).isEqualTo("4개 일치");
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000L);

        assertThat(Rank.FIFTH.getLabel()).isEqualTo("3개 일치");
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000L);
    }

    @Test
    @DisplayName("Rank 열거형의 각 등수가 올바른 일치 개수를 가져야 한다.")
    void Rank_열거형의_각_등수가_올바른_일치_개수를_가져야_한다() {
        assertThat(Rank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(Rank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(Rank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(Rank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(Rank.FIFTH.getMatchCount()).isEqualTo(3);
    }
}
