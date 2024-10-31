package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRewardTest {
    @Test
    void 로또보상_구하기() {
        assertThat(LottoReward.findByMatchCount(6)).isEqualTo(LottoReward.FIRST);
        assertThat(LottoReward.findByMatchCount(5)).isEqualTo(LottoReward.THIRD);
        assertThat(LottoReward.findByMatchCount(4)).isEqualTo(LottoReward.FOURTH);
        assertThat(LottoReward.findByMatchCount(3)).isEqualTo(LottoReward.FIFTH);
        assertThat(LottoReward.findByMatchCount(0)).isEqualTo(LottoReward.NONE);
    }
}
