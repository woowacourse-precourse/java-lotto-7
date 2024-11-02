package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @Nested
    @DisplayName("객체 생성 테스트" )
    class CreateLottoTest {
        @Test
        void 로또는_번호_리스트를_가진다() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // when
            List<Integer> actual = lotto.getNumbers();
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("예외 처리 테스트" )
    class LottoExceptionTest {
        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 로또 번호는 6개여야 합니다." );
        }

        @Test
        void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 로또 번호는 6개여야 합니다." );
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 중복된 번호가 있습니다." );
        }

        @Test
        void 로또_번호에_범위_외의_숫자가_있으면_예외가_발생한다() {
            final int MIN_LOTTO_NUMBER = 1;
            final int MAX_LOTTO_NUMBER = 45;

            assertAll(
                    () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                            .isInstanceOf(LottoException.class)
                            .hasMessage(
                                    format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)),
                    () -> assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                            .isInstanceOf(LottoException.class)
                            .hasMessage(
                                    format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER))
            );

        }
    }
}
