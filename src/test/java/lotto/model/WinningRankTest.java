package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningRankTest {

    @DisplayName("matchRank 메서드가 정확히 일치하는 랭크를 반환하는지 테스트")
    @Test
    void matchRank_메서드가_정확히_일치하는_랭크를_반환하는지_테스트() {
        // 1등 테스트: 6개 일치, 보너스 미포함
        assertThat(WinningRank.matchRank(6, false)).isEqualTo(WinningRank.FIRST);

        // 2등 테스트: 5개 일치, 보너스 포함
        assertThat(WinningRank.matchRank(5, true)).isEqualTo(WinningRank.SECOND);

        // 3등 테스트: 5개 일치, 보너스 미포함
        assertThat(WinningRank.matchRank(5, false)).isEqualTo(WinningRank.THIRD);

        // 4등 테스트: 4개 일치, 보너스 무관
        assertThat(WinningRank.matchRank(4, false)).isEqualTo(WinningRank.FOURTH);

        // 5등 테스트: 3개 일치, 보너스 무관
        assertThat(WinningRank.matchRank(3, false)).isEqualTo(WinningRank.FIFTH);

        // 일치하는 랭크가 없을 경우 null 반환 테스트
        assertThat(WinningRank.matchRank(2, false)).isNull();
    }

    @DisplayName("getPrize 메서드가 정확한 상금을 반환하는지 테스트")
    @Test
    void getPrize_메서드가_정확한_상금을_반환하는지_테스트() {
        assertThat(WinningRank.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(WinningRank.SECOND.getPrize()).isEqualTo(30000000);
        assertThat(WinningRank.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(WinningRank.FOURTH.getPrize()).isEqualTo(50000);
        assertThat(WinningRank.FIFTH.getPrize()).isEqualTo(5000);
    }

    @DisplayName("getMatchCount 메서드가 정확한 일치 개수를 반환하는지 테스트")
    @Test
    void getMatchCount_메서드가_정확한_일치_개수를_반환하는지_테스트() {
        assertThat(WinningRank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(WinningRank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(WinningRank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(WinningRank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(WinningRank.FIFTH.getMatchCount()).isEqualTo(3);
    }
}