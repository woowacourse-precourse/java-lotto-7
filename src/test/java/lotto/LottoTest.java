package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.Lotto;
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
    void 로또_번호와_당첨_번호_비교_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertEquals(6, lotto.countMatchingNumbers(List.of(1,2,3,4,5,6)));
        assertEquals(5, lotto.countMatchingNumbers(List.of(1,2,3,4,5,45)));
        assertEquals(4, lotto.countMatchingNumbers(List.of(1,2,3,4,44,45)));
        assertEquals(3, lotto.countMatchingNumbers(List.of(1,2,3,43,44,45)));
        assertEquals(2, lotto.countMatchingNumbers(List.of(1,2,42,43,44,45)));
        assertEquals(1, lotto.countMatchingNumbers(List.of(1,41,42,43,44,45)));
        assertEquals(0, lotto.countMatchingNumbers(List.of(40,41,42,43,44,45)));
    }

    @Test
    void 로또_번호와_보너스_번호_비교_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertTrue(lotto.isMatchingBonusNumber(1));
        assertFalse(lotto.isMatchingBonusNumber(7));
    }
}
