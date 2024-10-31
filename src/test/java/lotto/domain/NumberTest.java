package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.exception.CustomErrorCode;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 45})
    void 로또_조건을_만족하는_숫자를_입력받는다(int number) {
        // given
        Number lottoNumber = Number.from(number);

        // when
        int actual = lottoNumber.getNumber();

        // then
        assertThat(actual).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "45"})
    void 로또_조건을_만족하는_숫자_형식의_문자를_입력받는다(String number) {
        // given
        Number lottoNumber = Number.from(number);

        // when
        int actual = lottoNumber.getNumber();

        // then
        assertThat(actual).isEqualTo(Integer.parseInt(number));
    }

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @ParameterizedTest
        @NullAndEmptySource
        void 공백이나_빈_값이_입력된다(String number) {
            // when & then
            assertThatThrownBy(() -> Number.from(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_EMPTY_NUMBER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"//", "f", "a", "?"})
        void 숫자_형식이_아닌_값을_입력받는다(String number) {
            // when & then
            assertThatThrownBy(() -> Number.from(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_NOT_NUMBER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "000", "48", "-1", "-42"})
        void 로또_범위를_벗어난_숫자_형식의_문자를_입력받는다(String number) {
            // when & then
            assertThatThrownBy(() -> Number.from(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_LOTTO_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 48, -1, -42})
        void 로또_범위를_벗어난_숫자를_입력받는다(int number) {
            // when & then
            assertThatThrownBy(() -> Number.from(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_LOTTO_RANGE.getMessage());
        }
    }
}
