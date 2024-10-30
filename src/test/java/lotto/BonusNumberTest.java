package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {


    @Test
    void 정상_케이스(){
        BonusNumber bonusNumber = new BonusNumber(10);

        Assertions.assertNotNull(bonusNumber);
        Assertions.assertEquals(10, bonusNumber.getBonusNumber());
    }
    @Test
    void 보너스_번호는_1과_45_사이의_값을_가져야_한다_1() {
        assertThatThrownBy(() -> new BonusNumber(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호는_1과_45_사이의_값을_가져야_한다_2() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
