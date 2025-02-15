package lotto.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumbers);
    @Test
    void 보너스_번호가_0_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(0, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 보너스_번호가_46_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(46, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(1, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
