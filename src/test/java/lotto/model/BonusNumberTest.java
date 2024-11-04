package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 숫자가 범위(1-45)를 넘어가면 예외가 발생한다.")
    @Test
    void 보너스_숫자가_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 1이상 45이하의 숫자여야 합니다.");

        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 1이상 45이하의 숫자여야 합니다.");

    }

    @Test
    void 유효한_범위의_보너스_숫자로_객체가_생성된다() {
        BonusNumber bonusNumber = new BonusNumber(10);
        assertThat(bonusNumber.getNumber()).isEqualTo(10);
    }
}