package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스번호_생성() {
        //given
        BonusNumber bonusNumber = new BonusNumber(7);

        //when
        int number = bonusNumber.get();

        //then
        Assertions.assertThat(number).isEqualTo(7);
    }

    @Test
    void 보너스_번호가_1부터45_사이의_범위를_벗어나면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(46));
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(0));
    }

}