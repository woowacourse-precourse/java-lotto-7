package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumber.from("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumber.from("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_유효한_경우_객체를_생성한다() {
        BonusNumber bonusNumber = BonusNumber.from("10");
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(10);
    }
}
