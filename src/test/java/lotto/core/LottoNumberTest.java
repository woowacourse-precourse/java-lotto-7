package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45})
    void LottoNumber_생성(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 숫자가_1에서_45_범위를_벗어나면_예외(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    @Test
    void 숫자로_바꿀_수_없는_문자일_때_예외() {
        assertThatThrownBy(() -> LottoNumber.toLottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTERED_INVALID_NUMBER);

    }

    @Test
    void to_string() {
        assertThat(LottoNumber.from(1).toString()).isEqualTo("1");
    }

    @Test
    void 숫자_간_비교() {
        LottoNumber one = LottoNumber.from(1);
        LottoNumber two = LottoNumber.from(2);

        assertThat(two.compareTo(one)).isEqualTo(1);
        assertThat(one.compareTo(one)).isEqualTo(0);
        assertThat(one.compareTo(two)).isEqualTo(-1);
    }
}
