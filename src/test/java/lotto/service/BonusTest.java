package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("보너스 번호에 1 ~ 45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호에_1_부터_45_이외의_숫자가_있으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Bonus(50)).isInstanceOf(IllegalArgumentException.class);
    }
}