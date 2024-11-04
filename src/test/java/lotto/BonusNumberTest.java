package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_빈값이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_스페이스값이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(" ", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("a", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1에서_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("48", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("6", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
