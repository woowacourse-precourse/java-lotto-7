package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRewardTest {
    @Test
    void 로또보상_구하기() {
        assertThat(LottoReward.findByMatchCount(6, true)).isEqualTo(LottoReward.FIRST);
        assertThat(LottoReward.findByMatchCount(5, true)).isEqualTo(LottoReward.SECOND);
        assertThat(LottoReward.findByMatchCount(5, false)).isEqualTo(LottoReward.THIRD);
        assertThat(LottoReward.findByMatchCount(4, true)).isEqualTo(LottoReward.FOURTH);
        assertThat(LottoReward.findByMatchCount(3, true)).isEqualTo(LottoReward.FIFTH);
        assertThat(LottoReward.findByMatchCount(0, true)).isEqualTo(LottoReward.NONE);
    }
}
