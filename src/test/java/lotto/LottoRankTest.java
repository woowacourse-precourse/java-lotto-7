package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("당첨 등수 단위 테스트")
    @Test
    void win() {
        assertThat(LottoRank.win(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.win(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.win(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.win(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.win(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.win(2, false)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.win(1, false)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.win(0, false)).isEqualTo(LottoRank.BLANK);
    }
}