package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 로또_번호는_1부터_45사이의_숫자여야_한다() {
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
