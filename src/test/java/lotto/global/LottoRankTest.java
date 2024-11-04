package lotto.global;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("getMatchCount_메서드_테스트_01")
    @Test
    void 인자로_5를_전달하면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoRank.findByMatchCount(5))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("getMatchCount_메서드_테스트_02")
    @Test
    void 기능_테스트() {
        assertThat(LottoRank.findByMatchCount(6))
                .isEqualTo(LottoRank.FIRST);
    }
}