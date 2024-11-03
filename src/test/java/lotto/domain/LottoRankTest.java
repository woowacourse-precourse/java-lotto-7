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
}
