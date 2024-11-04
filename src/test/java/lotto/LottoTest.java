package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Nested
    class 생성자_테스트 {
        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 올바른_개수의_번호가_주어지면_객체가_정상_생성된다() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);
            assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        void 번호가_범위를_벗어나면_예외가_발생한다(int invalidNumber) {
            List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, invalidNumber);
            assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
    }

    @Nested
    class getNumbers_메소드_테스트 {
        @Test
        void 생성된_로또_번호는_수정이_불가능하다() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);
            List<Integer> lottoNumbers = lotto.getNumbers();

            assertThatThrownBy(() -> lottoNumbers.add(7))
                    .isInstanceOf(UnsupportedOperationException.class);
        }
    }

    @Nested
    class getMatchCount_메소드_테스트 {
        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 6, 3, 4, 5, 6, 7, 8, 4",
                "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0",
                "1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 6"
        })
        void 당첨_번호와의_일치_개수를_정확히_반환한다(
                int n1, int n2, int n3, int n4, int n5, int n6,
                int w1, int w2, int w3, int w4, int w5, int w6,
                int expectedMatchCount
        ) {
            Lotto lotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
            Lotto winningLotto = new Lotto(List.of(w1, w2, w3, w4, w5, w6));

            int matchCount = lotto.getMatchCount(winningLotto);

            assertThat(matchCount).isEqualTo(expectedMatchCount);
        }
    }

    @Nested
    class contains_메소드_테스트 {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6})
        void 번호가_포함되어_있으면_true를_반환한다(int number) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lotto.contains(number)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {7, 8, 9, 10, 11, 12})
        void 번호가_포함되어_있지_않으면_false를_반환한다(int number) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lotto.contains(number)).isFalse();
        }
    }
}
