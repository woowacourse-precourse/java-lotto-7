package lotto.statistics;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

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

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenIsNotInRangeInputWinningNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 65)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 알려주면 일치하는 숫자 개수를 반환한다.")
    @Test
    void shouldReturnCountMatchingNumbersWhenGiveMyLotto() {
        // give
        List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 6);
        Lotto winngLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int expectedMatchingCount = 3;

        // when
        int actualMatchingCount = winngLotto.countMatches(myLotto);

        // then
        Assertions.assertThat(actualMatchingCount).isEqualTo(expectedMatchingCount);
    }
}
