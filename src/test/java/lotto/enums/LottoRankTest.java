package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("LottoRank 검증 테스트")
    void valueOfMatchCount_firstPrize() {
        LottoRank rank = LottoRank.valueOfMatchCount(6, false);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000);
    }
}
