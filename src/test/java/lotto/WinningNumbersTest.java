package lotto;

import static lotto.exception.Exception.DUPLICATED_BONUS_NUMBERS;
import static lotto.exception.Exception.LOTTO_NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(DUPLICATED_BONUS_NUMBERS.getMessage());
    }

    @Test
    void 보너스_번호가_1부터_45_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 로또_번호가_범위를_벗어나는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 포함된 번호라면 true를 반환한다")
    void 숫자가_당첨_번호에_포함되어있는지_확인한다() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        boolean containsNumber = winningNumbers.isWinningNumber(1);

        // then
        assertThat(containsNumber).isTrue();
    }

    @Test
    @DisplayName("당첨 번호에 포함되지 않은 번호라면 false를 반환한다")
    void 숫자가_당첨_번호에_포함되어있는지_확인한다2() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        boolean containsNumber = winningNumbers.isWinningNumber(10);

        // then
        assertThat(containsNumber).isFalse();
    }

    @Test
    @DisplayName("로또가 보너스 번호를 포함하고 있다면 true를 반환한다")
    void 로또가_보너스_번호를_포함하고_있는지_확인한다() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        boolean containsBonus = winningNumbers.isBonusNumber(lotto);

        // then
        assertThat(containsBonus).isTrue();
    }

    @Test
    @DisplayName("로또가 보너스 번호를 포함하지 않는다면 false를 반환한다")
    void 로또가_보너스_번호를_포함하고_있는지_확인한다2() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        // when
        boolean containsBonus = winningNumbers.isBonusNumber(lotto);

        // then
        assertThat(containsBonus).isFalse();
    }
}