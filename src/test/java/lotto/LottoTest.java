package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("로또 당첨개수를 반환한다.")
    @Test
    void matchCount() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int matchCount = lotto.matchCount(winNumber, bonus);

        //then
        Assertions.assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또 당첨개수를 반환한다.")
    @Test
    void matchCountBonus() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int matchCount = lotto.matchCount(winNumber, bonus);

        //then
        Assertions.assertThat(matchCount).isEqualTo(6);
    }
}
