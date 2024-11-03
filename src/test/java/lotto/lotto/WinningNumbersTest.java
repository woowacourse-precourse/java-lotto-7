package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList();

            // when, then
            assertThatCode(() -> new WinningNumbers(numbers)).doesNotThrowAnyException();
        }

        @Test
        void should_throw_when_longer_than_6() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new WinningNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }

        @Test
        void should_throw_when_shorter_than_6() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new WinningNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }

        @Test
        void should_throw_when_duplicated_number() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 5).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new WinningNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    @Nested
    class TestContains {
        @Test
        void should_return_true() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber lottoNumber = new LottoNumber(1);

            // when
            boolean result = winningNumbers.contains(lottoNumber);

            // then
            assertThat(result).isTrue();
        }

        @Test
        void should_return_false() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber lottoNumber = new LottoNumber(7);

            // when
            boolean result = winningNumbers.contains(lottoNumber);

            // then
            assertThat(result).isFalse();
        }
    }
}
