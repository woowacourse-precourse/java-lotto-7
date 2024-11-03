package lotto.domain.vo;

import static org.assertj.core.api.Assertions.*;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class LottoNumberTests {
    @Test
    void testValidLottoNumber() {
        int validNumber = 10;
        LottoNumber lottoNumber = LottoNumber.of(validNumber);
        assertThat(lottoNumber.getValue()).isEqualTo(validNumber);
    }

    @Test
    void testInvalidLottoNumberThenThrowsException() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());

        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}