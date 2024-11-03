package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("1등 매칭")
    @Test
    void matchingFirst() {
        LottoRank rank = LottoRank.valueOf(6, false);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 매칭")
    @Test
    void matchingSecond() {
        LottoRank rank = LottoRank.valueOf(5, true);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 매칭")
    @Test
    void matchingThird() {
        LottoRank rank = LottoRank.valueOf(5, false);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 매칭")
    @Test
    void matchingFourth() {
        LottoRank rank = LottoRank.valueOf(4, false);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 매칭")
    @Test
    void matchingFifth() {
        LottoRank rank = LottoRank.valueOf(3, false);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("낙첨 매칭")
    @Test
    void matchingNone() {
        LottoRank rank = LottoRank.valueOf(2, false);

        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}
