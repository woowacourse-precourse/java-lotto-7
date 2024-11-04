package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 보너스_번호에_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("프리코스"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
