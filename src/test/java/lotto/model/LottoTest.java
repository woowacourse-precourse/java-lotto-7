package lotto.model;

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
    void 로또_번호에_0이하_46이상_넘어간_수가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .hasMessage("로또 번호는 1에서 45 사이만 가능합니다.");
    }

    @Test
    void 로또_번호_생성시_오름차순() {
        Lotto lotto = new Lotto(List.of(45, 1, 4, 12, 14, 16));

        List<Integer> list = List.of(1, 4, 12, 14, 16, 45);

        assertEquals(list, lotto.numbers());
    }

    @Test
    void 로또_번호_toString_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        String lottoString = lotto.toString();

        assertEquals("[1, 2, 3, 4, 5, 6]", lottoString);
    }

    @Test
    void 로또_번호와_winningNumber가_같을_때_count_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(6, lotto.correctCount(winningNumber));
    }

    @Test
    void 로또_번호와_보너스_번호가_같을_때_true() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int bonusNumber = 6;

        assertTrue(lotto.isBonus(bonusNumber));
    }

    @Test
    void 로또_번호와_보너스_번호가_없을_때_false() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int bonusNumber = 8;

        assertFalse(lotto.isBonus(bonusNumber));
    }
}
