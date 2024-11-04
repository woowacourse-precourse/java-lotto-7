package lotto.domain.winning;

import static lotto.constant.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.Error.RANGE_WINNING_NUMBER;
import static lotto.constant.Error.SIZE_WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("로또 번호의 적중 개수를 판단할 수 있다.")
    @Test
    void 로또_번호의_적중_개수를_판단할_수_있다() throws Exception {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 11, 12, 13));

        assertThat(winningNumbers.countHit(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘으면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(SIZE_WINNING_NUMBERS);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(SIZE_WINNING_NUMBERS);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_WINNING_NUMBERS);
    }

    @DisplayName("당첨 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1보다_작으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(RANGE_WINNING_NUMBER);
    }

    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 당첨_번호가_45보다_크면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(RANGE_WINNING_NUMBER);
    }
}