package lotto.system.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.system.utils.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createLottoNumber() {

        // given
        int validNumber = LottoConstants.LOTTO_NUMBER_LOWER_BOUND;

        // when
        LottoNumber lottoNumber = LottoNumber.of(validNumber);

        // then
        assertThat(lottoNumber.getValue()).isEqualTo(validNumber);
    }

    @DisplayName("로또 번호 유효 범위 테스트 - 예외 발생")
    @Test
    void invalidLottoNumberThrowsException() {

        // given
        int invalidNumber = LottoConstants.LOTTO_NUMBER_LOWER_BOUND - 1;

        // then
        assertThatThrownBy(() -> LottoNumber.of(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(
                                "번호는 %d부터 %d사이의 숫자여야 합니다.",
                                LottoConstants.LOTTO_NUMBER_LOWER_BOUND,
                                LottoConstants.LOTTO_NUMBER_UPPER_BOUND
                        )
                );
    }

    @DisplayName("로또 번호 비교 테스트")
    @Test
    void compareLottoNumbers() {

        // given
        LottoNumber number1 = LottoNumber.of(1);
        LottoNumber number2 = LottoNumber.of(2);

        // then
        assertThat(number1.compareTo(number2)).isLessThan(0);
        assertThat(number2.compareTo(number1)).isGreaterThan(0);
    }
}