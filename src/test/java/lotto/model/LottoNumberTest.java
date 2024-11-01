package lotto.model;

import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또_번호는_1에서_45_사이의_값이다() {
        // given
        int number = 3;

        // when
        LottoNumber lottoNumber = LottoNumber.from(number);

        // then
        assertEquals(lottoNumber.number(), number);
    }

    @Test
    void 로또_번호가_1에서_45_사이가_아니면_예외가_발생한다() {
        // given
        int number = 0;

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE_ERROR.message());
    }
}