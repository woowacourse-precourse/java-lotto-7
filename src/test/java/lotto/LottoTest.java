package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 로또_번호가_1부터_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,0,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호를_오름차순_정렬한다() {
        assertThat(new Lotto(List.of(6,5,4,3,2,1)).getSortedNumbers().toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 당첨개수를_반환한다() {
        List<Integer> winningNumbers = List.of(4,5,6,7,8,9);
        assertThat(new Lotto(List.of(1,2,3,4,5,6)).getMatchingNumberCount(winningNumbers))
                .isEqualTo(3);
    }

    @Test
    void 보너스번호_당첨여부를_반환한다() {
        int bonusNumber = 3;
        assertThat(new Lotto(List.of(1,2,3,4,5,6)).isBonusNumberMatched(bonusNumber))
                .isEqualTo(true);
    }
}
