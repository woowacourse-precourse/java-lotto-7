package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호의 범위가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
