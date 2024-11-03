package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스번호가_당첨번호와_중복이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(lotto.getNumbers(), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1에서_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(lotto.getNumbers(), 123))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
