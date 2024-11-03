package lotto;

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

    @Test
    void 로또_번호의_숫자가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 10, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ERROR_INVALID_RANGE);
    }

    @Test
    void 로또_번호를_당첨번호와_비교하여_일치하는_개수를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 6, 7, 10, 12);

        // when
        int countMatchingNumbers = lotto.countMatchingNumbers(winningNumbers);

        // then
        Assertions.assertThat(countMatchingNumbers).isEqualTo(3);
    }

    @Test
    void 로또_번호가_보너스번호와_일치하는지_확인한다() {
        // given
        Lotto lotto = new Lotto(List.of(12, 13, 15, 17, 20, 21));
        int bonusNumber = 15;

        // when
        boolean hasBonus = lotto.contains(bonusNumber);

        // then
        Assertions.assertThat(hasBonus).isTrue();
    }
}
