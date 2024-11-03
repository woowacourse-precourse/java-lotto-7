package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void shouldReturnCountWhenMatchWinningNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertEquals(0, lotto.matchWinningNumber(List.of(7,8,9,10,11,12)));
        assertEquals(1, lotto.matchWinningNumber(List.of(1,7,8,9,10,11)));
        assertEquals(2, lotto.matchWinningNumber(List.of(1,2,7,8,9,10)));
        assertEquals(3, lotto.matchWinningNumber(List.of(1,2,3,7,8,9)));
        assertEquals(4, lotto.matchWinningNumber(List.of(1,2,3,4,7,8)));
        assertEquals(5, lotto.matchWinningNumber(List.of(1,2,3,4,5,7)));
        assertEquals(6, lotto.matchWinningNumber(List.of(1,2,3,4,5,6)));
    }

    @Test
    void shouldReturnTrueWhenMatchBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertTrue(lotto.matchBonusNumber(6));
    }

    @Test
    void shouldReturnFalseWhenNoMatchBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertFalse(lotto.matchBonusNumber(7));
    }
}
