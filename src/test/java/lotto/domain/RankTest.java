package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("일치하는 숫자 개수와 보너스 번호 일치 여부로 Rank를 반환한다.")
    @Test
    void 일치숫자개수_보너스번호_일치여부로_Rank반환() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE);
    }

    @DisplayName("Rank의 당첨 금액과 일치 메시지를 확인한다.")
    @Test
    void Rank의_당첨금액_일치메시지_확인() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.FIRST.getMatchMessage()).isEqualTo("6개 일치 (2,000,000,000원)");

        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.SECOND.getMatchMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");

        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.THIRD.getMatchMessage()).isEqualTo("5개 일치 (1,500,000원)");

        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FOURTH.getMatchMessage()).isEqualTo("4개 일치 (50,000원)");

        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.FIFTH.getMatchMessage()).isEqualTo("3개 일치 (5,000원)");
    }
}
