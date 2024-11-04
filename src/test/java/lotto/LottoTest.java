package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 범위_밖의_로또번호_입력_시_예외테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(67, 8, 33, 21, 24, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 당첨번호_일치_갯수_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumberList = List.of(1,2,3,4,5,6);

        int matchCount = lotto.countMatches(winningNumberList);

        assertEquals(6, matchCount);
    }

    @Test
    void 보너스번호_포함여부_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        assertTrue(hasBonus);
    }
}
