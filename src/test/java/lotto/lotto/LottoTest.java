package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList();

            // when, then
            assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
        }

        @Test
        void should_throw_when_longer_than_6() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }

        @Test
        void should_throw_when_shorter_than_6() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }

        @Test
        void should_throw_when_duplicated_number() {
            // given
            List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 5).map(LottoNumber::new).toList();

            // when, then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
