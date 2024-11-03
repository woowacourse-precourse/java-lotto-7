package lotto;

import lotto.common.error.LottoErrorMessage;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoUnitTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INSUFFICIENT_WINNER_NUMBERS.getInfoMessage());
    }

    @Test
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INSUFFICIENT_WINNER_NUMBERS.getInfoMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.CONFLICT_WINNER_NUMBERS.getInfoMessage());
    }

    @DisplayName("로또 번호가 범위내의 숫자가 아니라면 발생한다.(45 초과)")
    @Test
    void 로또_번호가_범위내의_숫자가_아니라면_발생한다1() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INVALID_WINNER_NUMBERS.getInfoMessage());
    }

    @DisplayName("로또 번호가 범위내의 숫자가 아니라면 발생한다. (1 미만)")
    @Test
    void 로또_번호가_범위내의_숫자가_아니라면_발생한다2() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, -6);

        // when & then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INVALID_WINNER_NUMBERS.getInfoMessage());
    }

    @DisplayName("유효한 로또 번호가 입력되면 로또 객체가 생성된다.")
    @Test
    void 유효한_로또_번호로_객체가_생성된다() {
        // given
        List<Integer> validNumbers = List.of(8, 21, 23, 41, 42, 43);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 반환된다.")
    @Test
    void 로또_번호가_정렬되어_생성된다() {
        // given
        List<Integer> unsortedNumbers = List.of(43, 21, 8, 23, 41, 42);

        // when
        Lotto lotto = new Lotto(unsortedNumbers);

        // then
        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

}
