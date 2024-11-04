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

    @Test
    @DisplayName("Rank.from 메서드가 올바르게 Rank를 반환해야 한다.")
    void Rank_from_메서드가_올바르게_Rank를_반환해야_한다() {
        // 6개 일치, 보너스 불일치: 1등
        Rank rank1 = Rank.from(6, false);
        assertThat(rank1).isEqualTo(Rank.FIRST);

        // 5개 일치, 보너스 일치: 2등
        Rank rank2 = Rank.from(5, true);
        assertThat(rank2).isEqualTo(Rank.SECOND);

        // 5개 일치, 보너스 불일치: 3등
        Rank rank3 = Rank.from(5, false);
        assertThat(rank3).isEqualTo(Rank.THIRD);

        // 4개 일치: 4등
        Rank rank4 = Rank.from(4, false);
        assertThat(rank4).isEqualTo(Rank.FOURTH);

        // 3개 일치: 5등
        Rank rank5 = Rank.from(3, false);
        assertThat(rank5).isEqualTo(Rank.FIFTH);

        // 2개 일치: 등수 없음 (null)
        Rank rank6 = Rank.from(2, false);
        assertThat(rank6).isEqualTo(Rank.FAIL);
    }
}
