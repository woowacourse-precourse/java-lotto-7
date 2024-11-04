package lotto.model.number;

import lotto.model.exception.LottoNumberInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumber 테스트")
public class LottoNumberTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Test
    void 로또_번호가_최대값보다_크면_예외가_발생한다() {

        // given
        int exceededNumber = MAX_NUMBER + 1;

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(exceededNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_최소값보다_작으면_예외가_발생한다() {

        // given
        int exceededNumber = MIN_NUMBER - 1;

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(exceededNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_최소값과_최대값_사이에_있으면_예외가_발생하지_않는다() {

        // given
        int validNumber = MIN_NUMBER + MAX_NUMBER / 2;

        // when & then
        assertThatNoException().isThrownBy(() -> LottoNumber.from(validNumber));
    }

    @Test
    void 자신의_번호를_반환한다() {

        // given
        int number = MIN_NUMBER + MAX_NUMBER / 2;
        LottoNumber lottoNumber = LottoNumber.from(number);
        int expected = number;

        // when
        int actual = lottoNumber.getNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
