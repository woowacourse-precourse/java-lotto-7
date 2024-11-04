package lotto.vo;

import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Nested
    class 로또_번호_생성_테스트 {
        @Test
        void 유효한_번호로_로또_번호를_생성한다() {
            // given
            int number = 45;

            // when
            LottoNumber lottoNumber = LottoNumber.from(number);

            // then
            assertThat(lottoNumber.getValue()).isEqualTo(number);
        }

        @ParameterizedTest
        @ValueSource(ints = {MINIMUM_LOTTO_NUMBER, 23, MAXIMUM_LOTTO_NUMBER})
        void 경계값을_포함한_유효_범위_내의_번호로_생성한다(int number) {
            // when
            LottoNumber lottoNumber = LottoNumber.from(number);

            // then
            assertThat(lottoNumber.getValue()).isEqualTo(number);
        }

        @ParameterizedTest
        @ValueSource(ints = {
                Integer.MIN_VALUE, -1, 0,
                MINIMUM_LOTTO_NUMBER - 1
        })
        void 최소값보다_작은_번호로_생성할_수_없다(int invalidNumber) {
            assertThatThrownBy(() -> LottoNumber.from(invalidNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }

        @ParameterizedTest
        @ValueSource(ints = {
                MAXIMUM_LOTTO_NUMBER + 1,
                100, Integer.MAX_VALUE
        })
        void 최대값보다_큰_번호로_생성할_수_없다(int invalidNumber) {
            assertThatThrownBy(() -> LottoNumber.from(invalidNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    @Nested
    class 값_객체_동등성_테스트 {
        @Test
        void 같은_숫자로_생성된_로또_번호는_동등하다() {
            // given
            LottoNumber number1 = LottoNumber.from(1);
            LottoNumber number2 = LottoNumber.from(1);

            // then
            assertThat(number1)
                    .isEqualTo(number2)
                    .hasSameHashCodeAs(number2);
        }

        @Test
        void 다른_숫자로_생성된_로또_번호는_동등하지_않다() {
            // given
            LottoNumber number1 = LottoNumber.from(1);
            LottoNumber number2 = LottoNumber.from(2);

            // then
            assertThat(number1)
                    .isNotEqualTo(number2)
                    .doesNotHaveSameHashCodeAs(number2);
        }

        @Test
        void 로또_번호는_자기_자신과_동등하다() {
            // given
            LottoNumber number = LottoNumber.from(1);

            // then
            assertThat(number).isEqualTo(number);
        }

        @Test
        void 로또_번호는_null과_동등하지_않다() {
            // given
            LottoNumber number = LottoNumber.from(1);

            // then
            assertThat(number).isNotEqualTo(null);
        }

        @Test
        void 로또_번호는_다른_타입의_객체와_동등하지_않다() {
            // given
            LottoNumber number = LottoNumber.from(1);
            Object other = new Object();

            // then
            assertThat(number).isNotEqualTo(other);
        }
    }

    @Nested
    class 로또_번호_불변성_테스트 {
        @Test
        void 로또_번호의_값은_변경할_수_없다() {
            // given
            LottoNumber number = LottoNumber.from(1);
            int initialValue = number.getValue();

            // then
            assertThat(number.getValue()).isEqualTo(initialValue);
        }
    }

    @Test
    void 연속된_로또_번호_생성이_독립적으로_동작한다() {
        // given
        LottoNumber number1 = LottoNumber.from(1);
        LottoNumber number2 = LottoNumber.from(2);
        LottoNumber number3 = LottoNumber.from(1);

        // then
        assertThat(number1)
                .isEqualTo(number3)
                .isNotEqualTo(number2);
    }
}
