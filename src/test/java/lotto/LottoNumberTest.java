package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("생성자는 로또 번호의 범위를 벗어났을 때 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    public void constructor_WithOutOfRange_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        // given
        final int belowMinValue = LottoNumber.MIN_VALUE - 1;
        final int aboveMaxValue = LottoNumber.MAX_VALUE + 1;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(belowMinValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumber.OUT_OF_RANGE_ERROR_MESSAGE);

        assertThatThrownBy(() -> new LottoNumber(aboveMaxValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumber.OUT_OF_RANGE_ERROR_MESSAGE);
    }
}
