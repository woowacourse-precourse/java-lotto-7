package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    public void 로또번호_포함여부_확인() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        boolean result = lotto.containsNumber(6);

        //then
        assertTrue(result);
    }

    @Test
    public void 로또번호가_모두_일치할때_일치하는_숫자_개수는_6이다() {
        //given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        int result = lotto.countMatchingNumbers(winningLotto);

        //then
        Assertions.assertEquals(result, 6);
    }

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

}
