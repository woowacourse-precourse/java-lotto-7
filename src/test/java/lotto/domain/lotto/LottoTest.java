package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lottoMachine.BonusNumber;
import lotto.domain.lottoMachine.WinningLotto;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @Nested
    class Lotto_검증_테스트 {
        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,50", "0,1,2,3,4,5"})
        void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다(String numbers) {
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
            assertThatThrownBy(() -> Lotto.from("1,2,3,4"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_문자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> Lotto.from("1,2,3,4,5,a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 구분자가_콤마와_다를_경우_예외가_발생한다() {
            assertThatThrownBy(() -> Lotto.from("1:2:3:4:5:6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class Lotto_당첨_결과_테스트 {
        @Test
        void 로또_당첨_숫자_개수를_확인할_수_있다() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningLotto winningLotto = WinningLotto.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.from("7"));

            // when
            int matchCounts = lotto.getMatchCount(winningLotto);

            // then
            assertThat(matchCounts).isEqualTo(6);
        }
    }

}
