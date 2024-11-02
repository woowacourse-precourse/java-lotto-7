package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
    void 로또_번호와_당첨_번호의_일치하는_개수를_구한다() {
        Lotto lotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> matchNumbers = lotto.compareNumbersToWinningNumbers(winningNumbers);
        assertThat(1).isEqualTo(matchNumbers.size());
    }

    @Test
    void 로또_번호_중에_보너스_번호의_일치_여부를_구한다() {
        Lotto lotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));
        boolean hasBonusNumber = lotto.hasBonusNumber(1);
        assertThat(true).isEqualTo(hasBonusNumber);
    }
}
