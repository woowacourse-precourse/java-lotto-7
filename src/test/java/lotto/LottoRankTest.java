package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("일치하는 숫자와 보너스 번호에 따라 올바른 로또 등급을 반환한다.")
    @Test
    void fromMatchCount_일치하는_숫자와_보너스_번호로_올바른_등급을_반환한다() {
        // 주어진 조건에 따라 올바른 등급이 반환되는지 테스트합니다.
        assertThat(LottoRank.fromMatchCount(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.fromMatchCount(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.fromMatchCount(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.fromMatchCount(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.fromMatchCount(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("일치하는 숫자가 없을 경우 null을 반환한다.")
    @Test
    void fromMatchCount_일치하는_숫자가_없을_경우_null을_반환한다() {
        assertThat(LottoRank.fromMatchCount(0, false)).isNull();
        assertThat(LottoRank.fromMatchCount(2, false)).isNull();
    }

    @DisplayName("각 로또 등급의 속성을 확인한다.")
    @Test
    void 로또_등급의_속성을_확인한다() {
        assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.FIRST.getDescription()).isEqualTo("6개 일치");

        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(LottoRank.SECOND.getDescription()).isEqualTo("5개 일치, 보너스 볼 일치");

        assertThat(LottoRank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(LottoRank.THIRD.getDescription()).isEqualTo("5개 일치");

        assertThat(LottoRank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(LottoRank.FOURTH.getDescription()).isEqualTo("4개 일치");

        assertThat(LottoRank.FIFTH.getMatchCount()).isEqualTo(3);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(LottoRank.FIFTH.getDescription()).isEqualTo("3개 일치");
    }
}