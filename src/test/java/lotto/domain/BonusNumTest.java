package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BonusNumTest {

    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스번호가_당첨로또번호에_있는_번호() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNum(3, lotto.getNumbers()));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스번호가_로또_최대나_최소를_벗어남(int bonusNum) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNum(bonusNum, lotto.getNumbers()));
    }

    @Test
    void 주어진_로또에_보너스번호_있음() {
        BonusNum bonusNum = new BonusNum(7, lotto.getNumbers());
        Assertions.assertTrue(bonusNum.isContained(new Lotto(List.of(1, 2, 4, 5, 6, 7))));
    }

    @Test
    void 주어진_로또에_보너스번호_없음() {
        BonusNum bonusNum = new BonusNum(7, lotto.getNumbers());
        Assertions.assertFalse(bonusNum.isContained(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }
}
