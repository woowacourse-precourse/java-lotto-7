package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void valueOfTest() {
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.NONE);

        assertThat(LottoRank.valueOf(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, true)).isEqualTo(LottoRank.FIFTH);
    }
}