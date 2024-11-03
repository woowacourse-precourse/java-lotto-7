package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(8);

            // when, then
            assertThatCode(() -> new LottoResult(winningNumbers, bonusNumber)).doesNotThrowAnyException();
        }

        @Test
        void should_throw_when_has_common_number() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(5);

            // when, then
            assertThatThrownBy(() -> new LottoResult(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
