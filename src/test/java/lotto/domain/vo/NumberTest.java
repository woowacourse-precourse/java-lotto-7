package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25, 45})
    void 로또_번호가_범위_내일_때_정상_생성된다(int validLottoNumber) {
        // given // when
        Number number = Number.newInstance(validLottoNumber);

        // then
        assertThat(number.lottoNumber()).isEqualTo(validLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5})
    void 로또_번호가_최소_범위보다_작을_경우_예외가_발생한다(int invalidLottoNumber) {
        // given // when // then
        assertThatThrownBy(() -> Number.newInstance(invalidLottoNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 50})
    void 로또_번호가_최대_범위보다_클_경우_예외가_발생한다(int invalidLottoNumber) {
        // given // when // then
        assertThatThrownBy(() -> Number.newInstance(invalidLottoNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 다시 입력해 주세요.");
    }
}
