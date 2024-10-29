package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

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
