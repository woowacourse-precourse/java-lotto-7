package lotto.back.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.back.lotto.config.LottoConfig;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 숫자_범위_예외_테스트() {
        // given
        int underMin = LottoConfig.MIN_NUMBER.get() - 1;
        int overMax = LottoConfig.MAX_NUMBER.get() + 1;

        // when, then
        assertThatThrownBy(() -> new LottoNumber(underMin))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumber(overMax))
                .isInstanceOf(IllegalArgumentException.class);
    }
}