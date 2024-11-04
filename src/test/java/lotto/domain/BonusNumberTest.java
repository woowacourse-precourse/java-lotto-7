package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 로또_보너스_번호가_범위에서_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
