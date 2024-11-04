package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    @DisplayName("생성 성공 - 유효한 보너스 번호")
    void success_createBonusNumber() {
        // given
        int bonus = 7;

        // when
        BonusNumber bonusNumber = new BonusNumber(bonus);

        // then
        assertThat(bonusNumber.number()).isEqualTo(bonus);
    }

    @Test
    @DisplayName("생성 실패 - 범위를 벗어난 보너스 번호 (낮음)")
    void fail_createBonusNumber_belowRange() {
        // given
        int bonus = 0;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 1 이상 45 이하의 양의 정수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("생성 실패 - 범위를 벗어난 보너스 번호 (높음)")
    void fail_createBonusNumber_aboveRange() {
        // given
        int bonus = 46;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 1 이상 45 이하의 양의 정수만 입력 가능합니다.");
    }
}
