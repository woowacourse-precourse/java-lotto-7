package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호를 당첨 번호와 비교하여 일치하는 개수가 정확한지 파악한다.")
    @Test
    void 로또_번호를_당첨_번호와_비교하여_일치하는_개수가_정확한지_파악한다(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto.countWinningNumber(List.of(1, 2, 3, 4, 7, 8), 5))
                .isEqualTo(WinningCount.FIVE_AND_BONUS);
    }
}
