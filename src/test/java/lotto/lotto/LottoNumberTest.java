package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            int number = 1;

            //when, then
            assertThatCode(() -> new LottoNumber(number)).doesNotThrowAnyException();
        }

        @Test
        void should_throw_when_less_than_1() {
            // given
            int number = 0;

            // when, then
            assertThatThrownBy(() -> new LottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        @Test
        void should_throw_when_greater_than_45() {
            // given
            int number = 46;

            // when, then
            assertThatThrownBy(() -> new LottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
